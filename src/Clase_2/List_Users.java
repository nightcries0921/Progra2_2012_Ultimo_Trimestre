/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * List_Users.java
 *
 * Created on 09-nov-2012, 7:10:47
 */
package Clase_2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author Franklin
 */
public class List_Users extends javax.swing.JFrame {

    ArrayList<Usuarios>informacion;
    Container mainContainer;
    Container contenedores[][];
    Object objetos[][];
    JScrollPane scroll=new JScrollPane();
    int userSelected=0;
    public List_Users(ArrayList<Usuarios> val) {
        initComponents();
        informacion=val;
        inciar();
        addListeners();
        ((JLabel)this.objetos[this.userSelected][0]).setBorder(BorderFactory.createLineBorder(Color.RED,15));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-452)/2, (screenSize.height-510)/2, 452, 510);
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private void inciar() {
        this.mainContainer=new Container();
        this.contenedores=new Container[this.informacion.size()][2];
        this.objetos=new Object[this.informacion.size()][4];
        instanciarObjetos();
    }

    private void instanciarObjetos() {
        this.mainContainer.setBounds(5,5,200,500);
        //this.mainContainer.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.mainContainer.setLayout(new BoxLayout(mainContainer,BoxLayout.PAGE_AXIS));
        for(int i=0;i<this.informacion.size();i++){
            this.contenedores[i][0]=new Container();
            this.contenedores[i][0].setLayout(new BoxLayout(this.contenedores[i][0],BoxLayout.LINE_AXIS));
            this.contenedores[i][0].setSize(200,100);
            this.contenedores[i][1]=new Container();
            this.contenedores[i][1].setLayout(new BoxLayout(this.contenedores[i][1],BoxLayout.PAGE_AXIS));
            this.contenedores[i][1].setSize(100,100);
            this.objetos[i][0]=new JLabel();
            ((JLabel)this.objetos[i][0]).setSize(80,100);
            colocarImagen(i);
            this.objetos[i][1]=new JLabel(this.informacion.get(i).name);
            ((JLabel)this.objetos[i][1]).setSize(100,25);
            this.objetos[i][2]=new JLabel(this.informacion.get(i).apellido);
            ((JLabel)this.objetos[i][2]).setSize(100,25);
            this.objetos[i][3]=new JButton("Borrar");
            ((JButton)this.objetos[i][3]).setSize(60,25);
            ordenarObjetos(i);
        }
        
        scroll.setViewportView(this.mainContainer);
        scroll.setBounds(5, 5, 200, 500);
        scroll.setBorder(null);
        this.getContentPane().add(scroll);
     //   this.setContentPane(mainContainer);
    }

    private void colocarImagen(int i) {
        ImageIcon image=new ImageIcon(this.informacion.get(i).path);
        ImageIcon image2=new ImageIcon(image.getImage().getScaledInstance(((JLabel)this.objetos[i][0]).getWidth(), 
                ((JLabel)this.objetos[i][0]).getHeight(), Image.SCALE_DEFAULT));
        ((JLabel)this.objetos[i][0]).setIcon(image2);
    }

    private void ordenarObjetos(int i) {
        this.mainContainer.add(this.contenedores[i][0]);
        this.mainContainer.add(Box.createRigidArea(new Dimension(0,20)));
        this.contenedores[i][0].add(((JLabel)this.objetos[i][0]));
        this.contenedores[i][0].add(Box.createRigidArea(new Dimension(10,0)));
        this.contenedores[i][0].add(this.contenedores[i][1]);
        this.contenedores[i][1].add((JLabel)this.objetos[i][1]);
        this.contenedores[i][1].add(Box.createRigidArea(new Dimension(0,5)));
        this.contenedores[i][1].add((JLabel)this.objetos[i][2]);
        this.contenedores[i][1].add(Box.createRigidArea(new Dimension(0,5)));
        this.contenedores[i][1].add((JButton)this.objetos[i][3]);
    }

    private void addListeners() {
        for(int i=0;i<this.informacion.size();i++){
            final int vali=i;
            this.contenedores[i][0].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    setBorderContainer(vali);
                };
            });
        }
    }
    
    private void setBorderContainer(int i) {
        ((JLabel)this.objetos[this.userSelected][0]).setBorder(BorderFactory.createLineBorder(Color.black));
        this.userSelected=i;
        ((JLabel)this.objetos[this.userSelected][0]).setBorder(BorderFactory.createLineBorder(Color.RED,15));
    }
}
