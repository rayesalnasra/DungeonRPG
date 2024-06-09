/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DungeonRPG;

import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;


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
        game.getPlayerManager().resetInventory();
        setTextArea(game.printIntroduction());
        dropItem.setVisible(false);
        exitInventory.setVisible(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onExit();    
            }
            
        });
        
    }
    
    public void setGame(TextAdventure game) {
        this.game = game;
        exitInventoryActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
    }
    
    public void onExit(){
        quitGameActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
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
        loadGame = new javax.swing.JButton();
        saveGame = new javax.swing.JButton();
        restartGame = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
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

        quitGame.setText("QUIT TO MAIN MENU");
        quitGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitGameActionPerformed(evt);
            }
        });

        loadGame.setText("LOAD GAME");
        loadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGameActionPerformed(evt);
            }
        });

        saveGame.setText("SAVE GAME");
        saveGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGameActionPerformed(evt);
            }
        });

        restartGame.setText("RESTART GAME");
        restartGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartGameActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(dropItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitInventory))
                    .addComponent(checkInventory)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(moveWest)
                                .addGap(80, 80, 80)
                                .addComponent(moveEast)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(restartGame)
                                .addGap(18, 18, 18)
                                .addComponent(saveGame)
                                .addGap(31, 31, 31)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loadGame)
                            .addComponent(takeItem))))
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(moveNorth))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(moveSouth)
                        .addGap(130, 130, 130)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(quitGame)))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(checkInventory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropItem)
                    .addComponent(exitInventory))
                .addGap(21, 21, 21)
                .addComponent(moveNorth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moveEast)
                    .addComponent(moveWest)
                    .addComponent(takeItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moveSouth)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quitGame)
                    .addComponent(loadGame)
                    .addComponent(saveGame)
                    .addComponent(restartGame))
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
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
        dropItem.setVisible(true);
        moveNorth.setVisible(false);
        moveEast.setVisible(false);
        moveWest.setVisible(false);
        moveSouth.setVisible(false);
        takeItem.setVisible(false);
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
        exitInventory.setVisible(false);
        dropItem.setVisible(false);
        moveNorth.setVisible(true);
        moveEast.setVisible(true);
        moveWest.setVisible(true);
        moveSouth.setVisible(true);
        takeItem.setVisible(true);
        
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
            saveGameActionPerformed(evt); // Call the existing saveGameActionPerformed method
        } else if (option == JOptionPane.CANCEL_OPTION) {
            return; // Cancel quitting the game
        }

        // Dispose the current game window
        game.getPlayerManager().resetInventory();
        this.dispose();

        // Return to the main menu
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }//GEN-LAST:event_quitGameActionPerformed

    private void loadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGameActionPerformed
        // TODO add your handling code here:
        // Check if a save file exists
        boolean gameSaveExists = GameSaverLoader.doesGameSaveExist();

        if (gameSaveExists) {
            int option = JOptionPane.showConfirmDialog(this, "Do you want to load a saved game?",
                    "Load Game", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                // Load the game
                game = GameSaverLoader.loadGame();
                if (game != null) {
                    JOptionPane.showMessageDialog(this, "Game loaded successfully!", "Game Message",
                            JOptionPane.INFORMATION_MESSAGE);

                    exitInventoryActionPerformed(evt);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No save file exists.", "Game Message",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_loadGameActionPerformed

    private void restartGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartGameActionPerformed
        // TODO add your handling code here:
        boolean gameSaveExists = GameSaverLoader.doesGameSaveExist();
        if (gameSaveExists) {
            int option = JOptionPane.showConfirmDialog(this, "A game save exists. Do you want to load from the last save?", "Restart Game", JOptionPane.YES_NO_CANCEL_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                game = GameSaverLoader.loadGame();
                if (game != null) {
                    JOptionPane.showMessageDialog(this, "Game loaded successfully!", "Game Message", JOptionPane.INFORMATION_MESSAGE);
                    setTextArea(game.printIntroduction());
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to load the game.", "Game Message", JOptionPane.ERROR_MESSAGE);
                }
                return;
            }
        }

        int saveOption = JOptionPane.showConfirmDialog(this, "Do you want to save the current game before restarting? else all progress will be lost", "Restart Game", JOptionPane.YES_NO_CANCEL_OPTION);

        if (saveOption == JOptionPane.YES_OPTION) {
            saveGameActionPerformed(evt);
        } else if (saveOption == JOptionPane.CANCEL_OPTION) {
            return; // Cancel restarting the game
        }
        
        game.getPlayerManager().resetInventory();

        // Restart the game
        game = new TextAdventure();
        setTextArea(game.printIntroduction());
        exitInventoryActionPerformed(evt);
    }//GEN-LAST:event_restartGameActionPerformed

    private void saveGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameActionPerformed
        // TODO add your handling code here:
        boolean gameSaveExists = GameSaverLoader.doesGameSaveExist();
        String message;
        if (gameSaveExists) {
            message = "A game save already exists. Do you want to overwrite it?";
        } else {
            message = "Do you want to save the game?";
        }

        int option = JOptionPane.showConfirmDialog(this, message, "Save Game", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            GameSaverLoader.saveGame(game);
            JOptionPane.showMessageDialog(this, "Game saved successfully!", "Game Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_saveGameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GameSaverLoader.deleteGameSave();
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadGame;
    private javax.swing.JButton moveEast;
    private javax.swing.JButton moveNorth;
    private javax.swing.JButton moveSouth;
    private javax.swing.JButton moveWest;
    private javax.swing.JButton quitGame;
    private javax.swing.JButton restartGame;
    private javax.swing.JButton saveGame;
    private javax.swing.JButton takeItem;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
