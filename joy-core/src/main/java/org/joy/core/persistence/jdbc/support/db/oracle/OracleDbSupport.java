package org.joy.core.persistence.jdbc.support.db.oracle;

import org.joy.core.persistence.jdbc.model.vo.MdRdbColumn;
import org.joy.core.persistence.jdbc.model.vo.MdRdbTable;
import org.joy.core.persistence.jdbc.support.db.DbSupport;
import org.joy.core.persistence.jdbc.support.db.IDateFormatter;
import org.joy.core.persistence.jdbc.support.db.Schema;
import org.joy.core.persistence.jdbc.support.db.SqlStatementBuilder;
import org.joy.core.persistence.jdbc.support.enums.RdbType;
import org.joy.core.persistence.jdbc.support.utils.JdbcTool;

import java.sql.Connection;
import java.sql.Types;
import java.text.MessageFormat;

/**
 * Oracle-specific support.
 */
public class OracleDbSupport extends DbSupport {
	
	private static final String TABLE_COMMENT_SQL = "COMMENT ON TABLE {0} IS ''{1}''";
	private static final String ALTER_COLUMN_COMMENT_SQL = "COMMENT ON COLUMN {0}.{1} IS ''{2}''";
	private static final String ALTER_COLUMN_DEFAULT_VALUE_SQL = "ALTER TABLE {0} MODIFY {1} DEFAULT {2}";

	/**
	 * Creates a new instance.
	 * 
	 * @param connection The connection to use.
	 */
	public OracleDbSupport(Connection connection) {
		super(connection);
	}

	public String getScriptLocation() {
		return "com/googlecode/flyway/core/dbsupport/oracle/";
	}

	public String getCurrentUserFunction() {
		return "USER";
	}

	@Override
	protected String doGetCurrentSchema()  {
		return JdbcTool.queryForString(connection, "SELECT USER FROM dual");
	}

	@Override
	protected void doSetCurrentSchema(Schema schema)  {
		JdbcTool.execute(connection, "ALTER SESSION SET CURRENT_SCHEMA=" + schema);
	}

	public boolean supportsDdlTransactions() {
		return false;
	}

	public String getBooleanTrue() {
		return "1";
	}

	public String getBooleanFalse() {
		return "0";
	}

	public SqlStatementBuilder createSqlStatementBuilder() {
		return new OracleSqlStatementBuilder();
	}

	@Override
	public String doQuote(String identifier) {
		return "\"" + identifier + "\"";
	}

	@Override
	public Schema getSchema(String name) {
		return new OracleSchema(this, name);
	}

	@Override
	public boolean catalogIsSchema() {
		return false;
	}

	@Override
	public int getNullType() {
		return Types.VARCHAR;
	}

    @Override
    public String getSysDateFunction() {
        return "sysdate";
    }

    @Override
    protected IDateFormatter newDataFormatter() {
        return new OracleDateFormatter();
    }

    @Override
    public String getAlterTableCommentSql(MdRdbTable table) {
		String tableName = table.getName();
		String tableComment = table.getComment();
		return MessageFormat.format(TABLE_COMMENT_SQL, tableName, tableComment);
	}
	
	@Override
	public String getAlterColumnCommentSql(MdRdbTable table, MdRdbColumn column, MdRdbColumn columnInDb) {
		String columnName = column.getName();
		String columnComment = column.getComment().toString();
		return MessageFormat.format(ALTER_COLUMN_COMMENT_SQL, table.getName(), columnName, columnComment);
	}
	
	@Override
	public String getAlterColumnDefaultValueSql(MdRdbTable table, MdRdbColumn column, MdRdbColumn columnInDb) {
		String columnName = column.getName();
		String defaultValue = column.getDefaultValue();
        String type = columnInDb.getType().toLowerCase();
        if(type.contains("char")) {
            defaultValue = "'" + defaultValue + "'";
        }
		return MessageFormat.format(ALTER_COLUMN_DEFAULT_VALUE_SQL, table.getName(), columnName, defaultValue);
	}

    @Override
    public RdbType getDatabaseType() {
        return RdbType.ORACLE;
    }

}
