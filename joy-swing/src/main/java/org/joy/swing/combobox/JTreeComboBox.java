package org.joy.swing.combobox;


//~--- JDK imports ------------------------------------------------------------

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 下拉为树的类JComboBox的组件
 * @author allenwc
 */
public class JTreeComboBox extends javax.swing.JPanel {

    // 变量声明 - 不进行修改//GEN-BEGIN:variables

    /** Field description */
    private javax.swing.JButton collapseJButton;

    /** Field description */
    private JDialog dialog;

    /** Field description */
    private javax.swing.JTextField displayJTextField;

    // 变量声明结束//GEN-END:variables

    /**
     * 下拉框中的树
     */
    protected JTree tree;

    /** Field description */
    private JScrollPane treeJScrollPane;

    /**
     * Constructs ...
     *
     */
    public JTreeComboBox() {
        initComponents();
        treeJScrollPane = new JScrollPane();
        initDialog();
    }

    /**
     * Constructs ...
     *
     *
     * @param parent
     */
    public JTreeComboBox(JDialog parent) {
        initComponents();
        treeJScrollPane = new JScrollPane();
        initDialog(parent);
    }

    /**
     * 这个构造方法适用于父窗口为非有模式dialog时调用
     * @param tree 指定树
     */
    public JTreeComboBox(JTree tree) {
        initComponents();
        treeJScrollPane = new JScrollPane();
        initDialog();
        setTree(tree);
    }

    /**
     * 这个构造函数适用于父窗口为有模式的Dialog时调用
     * @param parent 父窗口
     * @param tree 指定的树
     */
    public JTreeComboBox(JDialog parent, JTree tree) {
        initComponents();
        treeJScrollPane = new JScrollPane();
        initDialog(parent);
        setTree(tree);
    }

    /**
     * Method description
     *
     */
    private void initDialog() {
        dialog = new JDialog((Frame) null, false);
        dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setUndecorated(true);
        dialog.setSize(200, 150);
        treeJScrollPane.setViewportView(new JTree());
        dialog.add(treeJScrollPane);
        dialog.addWindowFocusListener(new WindowAdapter() {
            public void windowLostFocus(WindowEvent e) {
                dialog.setVisible(false);
            }
        });
    }

    /**
     * Method description
     *
     *
     * @param parent
     */
    private void initDialog(JDialog parent) {
        dialog = new JDialog(parent, false);
        dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setUndecorated(true);
        dialog.setSize(200, 150);
        treeJScrollPane.setViewportView(new JTree());
        dialog.add(treeJScrollPane);
        dialog.addWindowFocusListener(new WindowAdapter() {
            public void windowLostFocus(WindowEvent e) {
                dialog.setVisible(false);
            }
        });
    }

    /**
     * 得到下拉窗中的树
     * @return 下拉窗中的树
     */
    public JTree getTree() {
        return tree;
    }

    /**
     * 设置下拉窗中的树
     * @param tree 自定义的树
     */
    public void setTree(JTree tree) {
        this.tree = tree;
        treeJScrollPane.setViewportView(tree);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                JTree t = (JTree) e.getSource();

                if (t.getLastSelectedPathComponent() != null) {
                    displayJTextField.setText(t.getLastSelectedPathComponent().toString());
                }

                dialog.setVisible(false);
            }
        });
    }

    /**
     * 得到所选取的对象
     * @return 所选取的对象
     */
    public Object getSelectedItem() {
        return getTree().getLastSelectedPathComponent();
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public JButton getCollapseJButton() {
        return this.collapseJButton;
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc=" 生成的代码 ">//GEN-BEGIN:initComponents
    private void initComponents() {
        displayJTextField = new javax.swing.JTextField();
        collapseJButton = new javax.swing.JButton();
        collapseJButton.setText("...");
        collapseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collapseJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);

        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(displayJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(collapseJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(displayJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(collapseJButton)));
    }    // </editor-fold>//GEN-END:initComponents

    /**
     * Method description
     *
     *
     * @param evt
     */
    private void collapseJButtonActionPerformed(java.awt.event.ActionEvent evt) {    // GEN-FIRST:event_collapseJButtonActionPerformed
        dialog.setLocation(displayJTextField.getLocationOnScreen().x, displayJTextField.getLocationOnScreen().y + displayJTextField.getHeight() + 5);
        dialog.setVisible(true);
    }    // GEN-LAST:event_collapseJButtonActionPerformed
}
