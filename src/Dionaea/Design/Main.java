/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dionaea.Design;
import Dionaea.Data.Honeypot;
import Dionaea.Data.SslConnection;
import Dionaea.Database.DbHoneypot;
import Dionaea.Database.DbMain;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author lap
 */

public final class Main extends javax.swing.JFrame {

    ArrayList<Honeypot> list;
    Honeypot hnew;
    DbMain db;
    int size;
    ResultSet rs ;
    String [][] rowAndColumn;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        //this.addNewHoneypot.setVisible(false);
        db = new DbMain();
        getHoneypots();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        dateFrom = new javax.swing.JComboBox();
        dateTo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        honeypotList = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dionaea");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filter", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        dateFrom.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N

        dateTo.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel4.setText("From");

        honeypotList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                honeypotListActionPerformed(evt);
            }
        });

        jLabel1.setText("Honeypots");

        jLabel3.setText("To");

        jLabel2.setText("Service");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(honeypotList, 0, 138, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateFrom)
                    .addComponent(honeypotList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2)))
                .addGap(6, 6, 6))
        );

        jButton1.setText("Go");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setEnabled(false);
        jScrollPane2.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenu1.setText("File");

        jMenuItem1.setText("add honeypot");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void addDionea()
    {/*
            Honeypot hnew = new Honeypot();
            hnew.setIp(this.addIp.getText().toString());
            hnew.setUsername(this.AddUsername.getText().toString());
            hnew.setName(this.addName.getText().toString());
            hnew.setPassword(new String(this.addPass.getPassword()));
            hnew.setPort(Integer.parseInt(this.AddPort.getText().toString()));
            hnew.setType("dionaea");
        try {            
            int id = db.addHoneypot(hnew);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            DbHoneypot dbhoneypot = new DbHoneypot("logsql.sqlite");
            
           // process(dbhoneypot,id);
            getHoneypots();*/
    }
    
    private void process(DbHoneypot dh , int a )
    {
        db.max();
        try {
            db.addConn(dh.resultOfConn(),a);
            db.addEmuProfile(dh.emuProfile());
            db.addEmuServices(dh.emu_serivces());
            db.addLogins(dh.logins());
            db.addMssql_commands(dh.mssql_command());
            db.addMssql_fingerprints(dh.mssql_fingerprint());
            db.addDcerpcbinds(dh.resultOfConnDcerpcbinds());
            db.addDcerpcrequests(dh.dcerpcrequests());
            db.addDownloads(dh.downloads());
            db.addOffers(dh.offers());
            db.addMysqlCommands(dh.mysqlCommands());
            db.addMysqlCommandArgs(dh.mysqlCommandsArgs());
            db.addP0fs(dh.p0fs());
            db.addSipCommands(dh.sip_commands());
            db.addSipAddrs(dh.sip_addrs());
            db.addSipSdpConnectiondatas(dh.sip_sdp_connectiondatas());
            db.addSipSdpMedia(dh.sip_sdp_medias());
            db.addSipSdpOrigins(dh.sip_sdp_origins());
            db.addSipVias(dh.sip_vias());
           // db.max();
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        AddHoneypot dialog = new AddHoneypot(this,true);
        hnew = dialog.result(list);
        getHoneypots();
        int id=-1;
        try {
             id = db.addHoneypot(hnew);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(hnew.getType().equalsIgnoreCase("Dioneae"))
        {
             DbHoneypot dbhoneypot = new DbHoneypot(hnew.getName().toString());
            
             process(dbhoneypot,id);
            
        }
        else
            try {
                db.max();
            db.addHoneyd(hnew.getName().toString(), id);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        getHoneypots();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void honeypotListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_honeypotListActionPerformed
        // TODO add your handling code here:
        Thread t = new Thread(new Runnable()
    	{
    		public void run()
    		{
    			updateIpList();
                        
                
                         
    		}
    	});
        t.start();
        
    }//GEN-LAST:event_honeypotListActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Timestamp from =  Timestamp.valueOf(this.dateFrom.getSelectedItem().toString());
        Timestamp to = Timestamp.valueOf(this.dateTo.getSelectedItem().toString());
        if(from.after(to))
            return ;
       String name = (String) honeypotList.getSelectedItem();
         if(name == null)
            return;
         int id = 0;
          String cmd = "";
         for(Honeypot h :list)
        {
            if (h.getName().equalsIgnoreCase(name))
                id = h.getId();
        }
         /* if(name.equalsIgnoreCase("All"))
            {
                cmd ="select DISTINCT remote_host ,datetime(connection_timestamp,'unixepoch'),connection_protocol ,honeypot"
                        + " from connections"
                        + " where datetime(connection_timestamp,'unixepoch') between "+"\""+from+" \" "
                        + " and "+"\""+to +"  order by datetime(connection_timestamp,'unixepoch') \"";
             }
          else
          {
              cmd ="select DISTINCT remote_host ,datetime(connection_timestamp,'unixepoch'),connection_protocol ,honeypot"
                        + " from connections"
                        + " where (datetime(connection_timestamp,'unixepoch') between "+"\""+from+" \" "
                        + " and "+"\""+to +" \")"
                        + " and honeypot =\""+String.valueOf(id)+"\" GROUP BY  remote_host order by datetime(connection_timestamp,'unixepoch')";
          }
       */
         if(!name.equalsIgnoreCase("All"))
       {
         cmd = "select remote_host,local_port ,datetime(connection_timestamp,'unixepoch'),connection_protocol ,honeypot from connections where honeypot=\""+String.valueOf(id)+"\" GROUP BY  remote_host order by datetime(connection_timestamp,'unixepoch') ";
       }
       else
          cmd = "select  remote_host,local_port ,datetime(connection_timestamp,'unixepoch'),connection_protocol ,honeypot from connections  GROUP BY  remote_host order by connection_timestamp";

         
        
        rs = db.exec("select count(*) from ("+cmd+");");
        //final int size = 0;
        
        try {
             
             size = rs.getInt("count(*)");
             //size =aInt;
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        rs = db.exec(cmd);
        String[] row = new String [5];
        
         String [] header={"Time","IP","local port","Protocol","honeypot"};
        
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(header);
        this.jTable1.setModel(model);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
         jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
         jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
        try {
            while(rs.next())
            {
                String temp = rs.getString("datetime(connection_timestamp,'unixepoch')");
                Timestamp time = Timestamp.valueOf(temp);
                try {
                    if( (time.after(from) || time.equals(from) ) && (time.before(to) || time.equals(to)) )
                    {
                            row[0] = temp;
                            row[1] = rs.getString("remote_host");
                            row[2] = rs.getString("local_port");
                            row[3] = rs.getString("connection_protocol");
                            int honey = rs.getInt("honeypot");
                            for(Honeypot h :list)
                            {
                                if(honey == h.getId())
                                    row[4] = h.getName();
                            }
                            //rowAndColumn[i][3] = list.get(i).getType();
                           model.addRow(row);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException ex) {            
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*Thread t = new Thread(new Runnable()
    	{
    		public void run()
    		{
    			initTable(rowAndColumn);
                
                         
    		}
    	});
        t.start();*/
       // this.jButton1.enable(false);

    }//GEN-LAST:event_jButton1ActionPerformed
       
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    public void getHoneypots()
    {
        String [] header={"name","IP","Username","type"};
        
        list = new ArrayList<Honeypot>();
        list.clear();
        list = db.getListOfHoneypot();
       /* String [][] rowAndColumn = new String [list.size()][4];
        for (int i =0 ;i<list.size();i++)
        {
            rowAndColumn[i][0] = list.get(i).getName();
            rowAndColumn[i][1] = list.get(i).getIp();
            rowAndColumn[i][2] = list.get(i).getUsername();
            rowAndColumn[i][3] = list.get(i).getType();
        }
        DefaultTableModel model = new DefaultTableModel();

       // JTable table = new JTable(rowAndColumn,header);
        // this.jTable1.setModel(model);
         model.setDataVector(rowAndColumn, header);
       //  model.addRow(rowAndColumn[2]);*/
         //honeypotList.removeAll();
         honeypotList.removeAllItems();
         honeypotList.addItem("All");
         for (int i =0 ;i<list.size();i++)
        {
            honeypotList.addItem(list.get(i).getName().toString());
        }
    }
    public void filterTime(String cmd)
    {
       /* String name = (String) honeypotList.getSelectedItem();
         if(name == null)
            return;
         int id = 0;
        String cmd="";
        for(Honeypot h :list)
        {
            if (h.getName().equalsIgnoreCase(name))
                id = h.getId();
        }
        if(!name.equalsIgnoreCase("All"))
       {
         cmd = "select DISTINCT datetime(connection_timestamp,'unixepoch') from connections where honeypot=\""+String.valueOf(id)+"\" order by datetime(connection_timestamp,'unixepoch') ;";
       }
       else
          cmd = "select DISTINCT datetime(connection_timestamp,'unixepoch') from connections order by datetime(connection_timestamp,'unixepoch');";
        ResultSet rs ;
       
        rs = db.exec(cmd);*/
        rs = db.exec(cmd);
        try {
            
            dateFrom.removeAllItems();
            dateTo.removeAllItems();
           // dateFrom.setModel(sampleModel);
          //  dateTo.setModel(sampleModel);
            
            while (rs.next())
                  {
                           //date = Long.parseLong(rs.getString("datetime(connection_timestamp,'unixepoch')"));
                         dateFrom.addItem(rs.getString("datetime(connection_timestamp,'unixepoch')"));
                         dateTo.addItem(rs.getString("datetime(connection_timestamp,'unixepoch')"));
                     }

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updateIpList()
    {
        String name = (String) honeypotList.getSelectedItem();
        

        if(name == null)
            return;
        int id = 0;
        String cmd="";
        for(Honeypot h :list)
        {
            if (h.getName().equalsIgnoreCase(name))
                id = h.getId();
        }
       
       if(!name.equalsIgnoreCase("All"))
       {
         cmd = "select remote_host ,local_port ,datetime(connection_timestamp,'unixepoch'),connection_protocol ,honeypot from connections where honeypot=\""+String.valueOf(id)+"\" GROUP BY  remote_host order by datetime(connection_timestamp,'unixepoch') ";
       }
       else
          cmd = "select  remote_host ,local_port ,datetime(connection_timestamp,'unixepoch'),connection_protocol ,honeypot from connections  GROUP BY  remote_host order by connection_timestamp";

        ResultSet rs ,size ;
        
        
        int sizer=0;
        try {
            size = db.exec("select count(*) from ("+cmd+");");
            sizer = size.getInt("count(*)");
            size.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        rs = db.exec(cmd);
        //this.rs = rs;
        initTable(rs,sizer);
        filterTime(cmd);
        
    }
    public void initTable(ResultSet rs , int size)
    {
        String [][] rowAndColumn = rowAndColumn = new String [size][5];
         String [] header={"Time","IP","local port","Protocol","honeypot"};
        int i =0;
        try {
            while(rs.next())
            {
                try {
                    
                    rowAndColumn[i][0] = rs.getString("datetime(connection_timestamp,'unixepoch')");
                    rowAndColumn[i][1] = rs.getString("remote_host");
                    rowAndColumn[i][2] = rs.getString("local_port");
                    rowAndColumn[i][3] = rs.getString("connection_protocol");
                    int honey = rs.getInt("honeypot");
                    for(Honeypot h :list)
                    {
                        if(honey == h.getId())
                            rowAndColumn[i][4] = h.getName();
                    }
                    //rowAndColumn[i][3] = list.get(i).getType();
                   i++;
                } catch (SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException ex) {            
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel model = new DefaultTableModel();
        //Arrays.sort(rowAndColumn[0]);
        TableColumnModel colMdl = jTable1.getColumnModel();
        
        
       
        model.setDataVector(rowAndColumn, header);
        
        this.jTable1.setModel(model);
       // jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
         jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
         jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.jButton1.enable(true);
    }
    public void initTable(String [][] rowAndColumn)
    {
       // String [][] rowAndColumn = rowAndColumn = new String [size][4];;
         String [] header={"Time","IP","Protocol","honeypot"};
        int i =0;
        
        DefaultTableModel model = new DefaultTableModel();
        //Arrays.sort(rowAndColumn[0]);
        model.setDataVector(rowAndColumn, header);
       // model.setColumnIdentifiers(header);
        this.jTable1.setModel(model);
        model.addRow(header);
        this.jButton1.enable(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox dateFrom;
    private javax.swing.JComboBox dateTo;
    private javax.swing.JComboBox honeypotList;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
