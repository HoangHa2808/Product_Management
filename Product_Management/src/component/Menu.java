package component;

import event.MenuEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import swing.home.MenuButton;
import swing.scroll.ScrollBarCustom;

public class Menu extends javax.swing.JPanel {

    private MenuEvent event;
    private MenuButton selectedMenu;
    private MenuButton unSelectedMenu;
    private Animator animator;

    public Menu() {
        initComponents();
        setOpaque(false);
        scroll.setViewportBorder(null);
        scroll.setBorder(null);
        scroll.getViewport().setOpaque(false);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        panelMenu.setLayout(new MigLayout("wrap, fillx, inset 0", "[fill]"));
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                selectedMenu.setAnimate(fraction);
                if (unSelectedMenu != null) {
                    unSelectedMenu.setAnimate(1f - fraction);
                }
            }
        };
        animator = new Animator(300, target);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        animator.setResolution(0);
    }

    public void initMenu(MenuEvent event) {
        this.event = event;
        addMenu("product", "Product", 0);
        addMenu("category", "Category", 1);
        addMenu("order", "Order", 2);
        addMenu("customer", "Customer", 3);
        addMenu("user", "User", 4);
        addMenu("role", "Role", 5);
        space();
        addMenu("log-out", "Logout", 6);
        this.event.menuSelected(6);
    }

    private void addMenu(String icon, String text, int index) {
        MenuButton menu = new MenuButton(index);
        setFont(menu.getFont().deriveFont(Font.PLAIN, 16));
        setForeground(new Color(242,231,213));
        menu.setIcon(new ImageIcon(getClass().getResource("/icon/" + icon + ".png")));
        menu.setText("  " + text);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    if (menu != selectedMenu) {
                        unSelectedMenu = selectedMenu;
                        selectedMenu = menu;
                        animator.start();
                        event.menuSelected(index);
                    }
                }
            }
        });
        panelMenu.add(menu);
    }

    private void space() {
        panelMenu.add(new JLabel(), "push");
    }

    public void setSelected(int index) {
        for (Component com : panelMenu.getComponents()) {
            MenuButton menu = (MenuButton) com;
            if (menu.getIndex() == index) {
                if (menu != selectedMenu) {
                    selectedMenu = menu;
                    animator.start();
                    event.menuSelected(index);
                }
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        imgAvatar = new swing.home.ImageAvatar();
        scroll = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();

        setBackground(new java.awt.Color(120, 149, 178));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 231, 213));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANAGEMENT");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));

        imgAvatar.setBorderSize(3);
        imgAvatar.setBorderSpace(2);
        imgAvatar.setGradientColor1(new java.awt.Color(174, 189, 202));
        imgAvatar.setGradientColor2(new java.awt.Color(232, 223, 202));
        imgAvatar.setImage(new javax.swing.ImageIcon("E:\\summer\\Image\\3f1ff404e8c32f9d76d2.jpg")); // NOI18N

        panelMenu.setForeground(new java.awt.Color(242, 231, 213));
        panelMenu.setOpaque(false);
        panelMenu.setPreferredSize(new java.awt.Dimension(205, 378));
        panelMenu.setRequestFocusEnabled(false);
        panelMenu.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );

        scroll.setViewportView(panelMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(imgAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(scroll))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.home.ImageAvatar imgAvatar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
