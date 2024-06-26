/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DungeonRPG;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author billg
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onExit();    
            }
          
        });
        
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

        gameTitle = new javax.swing.JLabel();
        newGame = new javax.swing.JButton();
        loadGame = new javax.swing.JButton();
        quitGame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DUNGEONRPG - MAIN MENU");
        setPreferredSize(new java.awt.Dimension(600, 500));
        setResizable(false);

        gameTitle.setFont(new java.awt.Font("Segoe UI", 0, 60)); // NOI18N
        gameTitle.setText("Dungeon RPG");

        newGame.setText("NEW GAME");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });

        loadGame.setText("LOAD GAME");
        loadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadGameActionPerformed(evt);
            }
        });

        quitGame.setText("QUIT");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(newGame))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(loadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(quitGame)))
                .addContainerGap(250, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(gameTitle)
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(gameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newGame)
                .addGap(18, 18, 18)
                .addComponent(loadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quitGame)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadGameActionPerformed
        // TODO add your handling code here:
        // Check if a save file exists
        boolean gameSaveExists = GameSaverLoader.doesGameSaveExist();

        if (gameSaveExists) {
            int option = JOptionPane.showConfirmDialog(this, "Do you want to load a saved game?",
                    "Load Game", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                TextAdventure game = GameSaverLoader.loadGame();
                if (game != null) {
                    JOptionPane.showMessageDialog(this, "Game loaded successfully!", "Game Message",
                            JOptionPane.INFORMATION_MESSAGE);

                    // Open the game GUI and load the game state
                    GUI gui = new GUI();
                    gui.setGame(game);  // Ensure this method exists to set the loaded game state
                    gui.setVisible(true);
                    this.dispose(); // Close the main menu
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No save file exists.", "Game Message",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_loadGameActionPerformed

    private void quitGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitGameActionPerformed
        // TODO add your handling code here:
         int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?",
                "Quit Game", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_quitGameActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        // TODO add your handling code here:
        // Open the GraphicalUserInterface
        GUI gui = new GUI();
        gui.setVisible(true);  // Show the game GUI
        this.dispose();  // Close the main menu
    }//GEN-LAST:event_newGameActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gameTitle;
    private javax.swing.JButton loadGame;
    private javax.swing.JButton newGame;
    private javax.swing.JButton quitGame;
    // End of variables declaration//GEN-END:variables
}
