/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DungeonRPG;

import javax.swing.JOptionPane;

/**
 *
 * @author billg
 */
public class GUI extends javax.swing.JFrame {
    private static TextAdventure game;
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        this.game = new TextAdventure();
        setTextArea(game.printIntroduction());
        dropItem.setVisible(false);
        exitInventory.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        moveNorth = new javax.swing.JButton();
        moveSouth = new javax.swing.JButton();
        moveEast = new javax.swing.JButton();
        moveWest = new javax.swing.JButton();
        checkInventory = new javax.swing.JButton();
        dropItem = new javax.swing.JButton();
        exitInventory = new javax.swing.JButton();
        takeItem = new javax.swing.JButton();
        quitGame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dungeon RPG");
        setPreferredSize(new java.awt.Dimension(600, 500));
        setResizable(false);

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        moveNorth.setText("MOVE NORTH");
        moveNorth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveNorthActionPerformed(evt);
            }
        });

        moveSouth.setText("MOVE SOUTH");
        moveSouth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveSouthActionPerformed(evt);
            }
        });

        moveEast.setText("MOVE EAST");
        moveEast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveEastActionPerformed(evt);
            }
        });

        moveWest.setText("MOVE WEST");
        moveWest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveWestActionPerformed(evt);
            }
        });

        checkInventory.setText("CHECK INVENTORY");
        checkInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInventoryActionPerformed(evt);
            }
        });

        dropItem.setText("DROP ITEM");
        dropItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropItemActionPerformed(evt);
            }
        });

        exitInventory.setText("EXIT INVENTORY");
        exitInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitInventoryActionPerformed(evt);
            }
        });

        takeItem.setText("TAKE ITEM");
        takeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takeItemActionPerformed(evt);
            }
        });

        quitGame.setText("QUIT GAME");
        quitGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(checkInventory)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(quitGame)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitInventory)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(moveWest)
                                    .addGap(81, 81, 81)
                                    .addComponent(moveEast))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(moveNorth)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(dropItem)
                                                .addGap(10, 10, 10))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(moveSouth)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(takeItem)
                                                .addGap(127, 127, 127))))))
                            .addGap(17, 17, 17)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(checkInventory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moveNorth)
                    .addComponent(dropItem))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moveEast)
                    .addComponent(moveWest))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moveSouth)
                    .addComponent(takeItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitInventory)
                    .addComponent(quitGame))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void moveNorthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveNorthActionPerformed
        // TODO add your handling code here:
        String gameOutput = game.runCommand("Move North");
        setTextArea(gameOutput);
    }//GEN-LAST:event_moveNorthActionPerformed

    private void moveSouthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveSouthActionPerformed
        // TODO add your handling code here:
        String gameOutput = game.runCommand("Move South");
        setTextArea(gameOutput);
    }//GEN-LAST:event_moveSouthActionPerformed

    private void moveEastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveEastActionPerformed
        // TODO add your handling code here:
        String gameOutput = game.runCommand("Move East");
        setTextArea(gameOutput);
    }//GEN-LAST:event_moveEastActionPerformed

    private void moveWestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveWestActionPerformed
        // TODO add your handling code here:
        String gameOutput = game.runCommand("Move West");
        setTextArea(gameOutput);
    }//GEN-LAST:event_moveWestActionPerformed

    private void checkInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInventoryActionPerformed
        // TODO add your handling code here:
        String gameOutput = game.runCommand("Check Inventory");
        setTextArea(gameOutput);
        dropItem.setVisible(true);
        exitInventory.setVisible(true);
    }//GEN-LAST:event_checkInventoryActionPerformed

    private void dropItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropItemActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog("What Item would you like to drop");

        if (input == null) {
            // User hit cancel, just return without doing anything
            return;
        }

        String gameOutput = game.runCommand("Drop " + input);
        JOptionPane.showMessageDialog(this, gameOutput, "Game Message", JOptionPane.INFORMATION_MESSAGE);
        checkInventoryActionPerformed(evt);
    }//GEN-LAST:event_dropItemActionPerformed

    private void exitInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitInventoryActionPerformed
        // TODO add your handling code here:
        String gameOutput = game.runCommand("Observe Area");
        setTextArea(gameOutput);
        
    }//GEN-LAST:event_exitInventoryActionPerformed

    private void takeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeItemActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog("What item would you like to pickup");

        if (input == null) {
            // User hit cancel, just return without doing anything
            return;
        }

        String gameOutput = game.runCommand("Take " + input);
        JOptionPane.showMessageDialog(this, gameOutput, "Game Message", JOptionPane.INFORMATION_MESSAGE);
        exitInventoryActionPerformed(evt);
    }//GEN-LAST:event_takeItemActionPerformed

    private void quitGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitGameActionPerformed
        // TODO add your handling code here:
        String message = "Do you want to save the game before quitting?";
        int option = JOptionPane.showConfirmDialog(this, message, "Quit Game", JOptionPane.YES_NO_CANCEL_OPTION);

        if (option == JOptionPane.YES_OPTION) {
             // add save game function here
        } else if (option == JOptionPane.CANCEL_OPTION) {
            return; // Cancel quitting the game
        }
        System.exit(0); // Quit the application
    }//GEN-LAST:event_quitGameActionPerformed
    
    private void setTextArea(String output) {
        textArea.setText(output);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkInventory;
    private javax.swing.JButton dropItem;
    private javax.swing.JButton exitInventory;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton moveEast;
    private javax.swing.JButton moveNorth;
    private javax.swing.JButton moveSouth;
    private javax.swing.JButton moveWest;
    private javax.swing.JButton quitGame;
    private javax.swing.JButton takeItem;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
