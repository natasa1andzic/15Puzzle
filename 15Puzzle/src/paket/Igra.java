package paket;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

	public class Igra implements WindowListener,ActionListener {
		
	    private JFrame mFrame;
	    private JPanel mPanel1,mPanel2;
	    private JButton mBtn[], randomBtn;
	    private JTextField mTxtField;
	    private JLabel mLabel;
	    int a;
	    int brojKlikova;
	    
	    void namestiDugmice() {
	        for (int i=0;i<9;i++)
	        	mBtn[i].setText("0");
	        mBtn[8].setText("");
	        a=8;}
	    
	    Igra() {
	        a=8;
	        mFrame=new JFrame("Natasa Andzic");
	        mPanel1=new JPanel();
	        mPanel2=new JPanel();
	        mBtn=new JButton[9];
	        randomBtn=new JButton("Promesaj");
	        for (int i=0;i<9;i++)
	        	mBtn[i]=new JButton("0");
	        mBtn[8].setText("");
	        mTxtField=new JTextField(5);
	        mLabel=new JLabel("Broj klikova: ");
	        mPanel1.setLayout(new GridLayout(3, 3));
	        for (int i=0;i<9;i++)
	        	mPanel1.add(mBtn[i]);
	        mPanel2.add(mLabel);
	        mPanel2.add(mTxtField);
	        mPanel2.add(randomBtn);
	        (mFrame.getContentPane()).setLayout(new GridLayout(2, 1));
	        (mFrame.getContentPane()).add(mPanel1);
	        (mFrame.getContentPane()).add(mPanel2);
	        mFrame.setSize(600, 600);
	        mFrame.setVisible(true);
	        mFrame.addWindowListener(this);
	        mFrame.setResizable(false);
	        ImageIcon img = new ImageIcon("gamepad-icon.png");
	        mFrame.setIconImage(img.getImage());
	        randomMetod();
	        randomBtn.addActionListener(this);
	        for (int i=0;i<9;i++)
	        	mBtn[i].addActionListener(this);
	        brojKlikova=0;
	        pretvoriBrojKlikovaUString();
	    }
	    void pretvoriBrojKlikovaUString()
	    {
	    	mTxtField.setText(Integer.toString(brojKlikova));
	    }
	    void randomMetod()
	    {
	        Random r=new Random();
	        for (int i=0;i<8;)
	        {
	            int j=r.nextInt(9);
	            if (mBtn[j].getText().equals("0"))
	            {
	            	mBtn[j].setText(Integer.toString(i+1));
	                i++;
	            }
	        }
	    }

	    public void windowOpened(WindowEvent we) 
	    {
	        
	    }

	    public void windowClosing(WindowEvent we) 
	    {
	        System.exit(0);
	    }

	    public void windowClosed(WindowEvent we) 
	    {
	        
	    }

	    public void windowIconified(WindowEvent we) 
	    {
	        
	    }

	    public void windowDeiconified(WindowEvent we) 
	    {
	        
	    }

	    public void windowActivated(WindowEvent we) 
	    {
	        
	    }

	    public void windowDeactivated(WindowEvent we) 
	    {
	        
	    }
	    

	    void provera() {
	        boolean gotovo=false;
	        for (int i=0;i<8;i++)
	        {
	            if (mBtn[i].getText().equals(Integer.toString(i+1)))
	                gotovo=true;
	            else {
	                gotovo=false;
	                break;        
	            }
	        }
	        if (gotovo){
	            JOptionPane.showMessageDialog(mFrame,"Presli ste igru u " +brojKlikova+ " klikova! Bravo");
	            brojKlikova=0;
	            namestiDugmice();
	            randomMetod();
	            pretvoriBrojKlikovaUString();
	        }
	    }
	    public void actionPerformed(ActionEvent ae) {
	        if (ae.getSource()==randomBtn){
	            namestiDugmice();
	            randomMetod();
	            brojKlikova=0;
	            pretvoriBrojKlikovaUString();
	            return;
	        }
	        for (int i=0;i<9;i++){
	            if (ae.getSource()==mBtn[i]){
	                brojKlikova++;
	                pretvoriBrojKlikovaUString();
	                boolean promeni=false;
	                
	                if(a==0 && (i==1 || i==3))
	                	promeni=true;
	                
	                if(a==1 && (i==0 || i==2 || i==4))
	                	promeni=true;
	                
	                if(a==2 && (i==1 || i==5))
	                	promeni=true;
	                
	                if(a==3 && (i==0 || i==4 || i==6))
	                	promeni=true;
	                
	                if(a==4 && (i==1 || i==3 || i==5 || i==7))
	                	promeni=true;
	                
	                if(a==5 && (i==2 || i==4 || i==8))
	                	promeni=true;
	                
	                if(a==6 && (i==3 || i==7))
	                	promeni=true;
	                
	                if(a==7 && (i==4 || i==6 || i==8))
	                	promeni=true;
	                
	                if(a==8 && (i==5 || i==7))
	                	promeni=true;
	                
	                if (promeni){
	                	mBtn[a].setText(mBtn[i].getText());
	                    a=i;
	                    mBtn[a].setText("");
	                    provera();
	                }
	            }
	        }
	    }}