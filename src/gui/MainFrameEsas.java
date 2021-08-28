/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Dao.*;
import Dao.Imple.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


import gui.AddAirport;
import gui.Update.UpdateAirport;
import Model.Flight;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MainFrameEsas extends javax.swing.JFrame {

    PassengerDao dao = new PassengerDaoImple();
    FlightDao flightDao = new FlightDaoImple();
    Flight_PassengerDao flight_PassengerDao = new Flight_PassengerDaoImple();
    AirportDao airportDao = new AirportDaoImple();
    PlaneDao planeDao = new PlaneDaoImple();
    CompanyDao companyDao = new CompanyDaoImple();
    WorkerDao workerDao = new WorkerDaoImple();
    String clickedButtonId = null;
    int GlobBtn = 0;

    /**
     * Creates new form MainFrame
     */
    public MainFrameEsas() {
        initComponents();
        List<Model.Passenger> list = new ArrayList<>();
        try {
            list = dao.getPassengerList();
            showPassengerList(list);
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }
        showPassengerList(list);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        jPanel2 = new javax.swing.JPanel();
        FlightBtn = new javax.swing.JButton();
        FlightPassengerBtn = new javax.swing.JButton();
        PassengerBtn = new javax.swing.JButton();
        AirportBtn = new javax.swing.JButton();
        PlaneBtn = new javax.swing.JButton();
        CompanyBtn = new javax.swing.JButton();
        WorkerBtn = new javax.swing.JButton();
        FlightStatisticsBtn = new javax.swing.JButton();
        WorkerBtn2 = new javax.swing.JButton();
        WorkerBtn3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        GlobTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        keywordTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        addİd = new javax.swing.JButton();
        updateİd = new javax.swing.JButton();
        deleteİd = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        button1.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        FlightBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        FlightBtn.setText("Flight");
        FlightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlightBtnActionPerformed(evt);
            }
        });

        FlightPassengerBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        FlightPassengerBtn.setText("Flight_Passenger");
        FlightPassengerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlightPassengerBtnActionPerformed(evt);
            }
        });

        PassengerBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PassengerBtn.setText("Passenger");
        PassengerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassengerBtnActionPerformed(evt);
            }
        });

        AirportBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AirportBtn.setText("Airport");
        AirportBtn.setPreferredSize(new java.awt.Dimension(71, 23));
        AirportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AirportBtnActionPerformed(evt);
            }
        });

        PlaneBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PlaneBtn.setText("Plane");
        PlaneBtn.setPreferredSize(new java.awt.Dimension(71, 23));
        PlaneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaneBtnActionPerformed(evt);
            }
        });

        CompanyBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CompanyBtn.setText("Company");
        CompanyBtn.setPreferredSize(new java.awt.Dimension(71, 23));
        CompanyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompanyBtnActionPerformed(evt);
            }
        });

        WorkerBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        WorkerBtn.setText("Worker");
        WorkerBtn.setPreferredSize(new java.awt.Dimension(71, 23));
        WorkerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WorkerBtnActionPerformed(evt);
            }
        });

        FlightStatisticsBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        FlightStatisticsBtn.setText("Flight Statistics");
        FlightStatisticsBtn.setPreferredSize(new java.awt.Dimension(71, 23));
        FlightStatisticsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlightStatisticsBtnActionPerformed(evt);
            }
        });

        WorkerBtn2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        WorkerBtn2.setText("Airport Statistics");
        WorkerBtn2.setPreferredSize(new java.awt.Dimension(71, 23));
        WorkerBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WorkerBtn2ActionPerformed(evt);
            }
        });

        WorkerBtn3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        WorkerBtn3.setText("Ticket Statistics"); // NOI18N
        WorkerBtn3.setPreferredSize(new java.awt.Dimension(71, 23));
        WorkerBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WorkerBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(WorkerBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(WorkerBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FlightStatisticsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(WorkerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CompanyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlaneBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AirportBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PassengerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FlightPassengerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FlightBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(FlightBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(FlightPassengerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PassengerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(AirportBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PlaneBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(CompanyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(WorkerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(FlightStatisticsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(WorkerBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(WorkerBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        GlobTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ){public boolean isCellEditable(int row, int column){return false;}}
    );
    GlobTable.setShowVerticalLines(false);
    GlobTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            GlobTableMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(GlobTable);

    keywordTxt.setBorder(null);
    keywordTxt.setPreferredSize(new java.awt.Dimension(50, 14));
    keywordTxt.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            keywordTxtKeyReleased(evt);
        }
    });

    searchBtn.setText("Search");
    searchBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    searchBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            searchBtnActionPerformed(evt);
        }
    });

    addİd.setText("Add");
    addİd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addİdActionPerformed(evt);
        }
    });

    updateİd.setText("Update");
    updateİd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            updateİdActionPerformed(evt);
        }
    });

    deleteİd.setText("Delete");
    deleteİd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            deleteİdActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addComponent(addİd, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
            .addGap(26, 26, 26)
            .addComponent(updateİd, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(deleteİd, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
            .addGap(135, 135, 135)
            .addComponent(keywordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(19, 19, 19))
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap(27, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addİd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateİd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteİd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keywordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1)
        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    /*  public boolean isCellEditable(int row, int column) {
     *     return false;
     * }
     */

    private void PassengerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassengerBtnActionPerformed
        try {
            GlobBtn = 3;
            showPassengerList(dao.getPassengerList());
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_PassengerBtnActionPerformed

    private void FlightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlightBtnActionPerformed
        GlobBtn = 1;
        try {
            GlobBtn = 1;
            showFlightList(flightDao.getFlightList());
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_FlightBtnActionPerformed

    private void addİdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addİdActionPerformed
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x, y;

        switch (GlobBtn) {
            case 1:
                gui.AddFlight addFlight = new gui.AddFlight();
                x = (int) ((dimension.getWidth() - addFlight.getWidth()) / 2);
                y = (int) ((dimension.getHeight() - addFlight.getHeight()) / 2);
                addFlight.setLocation(x, y);
                addFlight.setVisible(true);
                break;

            case 2:
                gui.AddFlight_Passenger addFlight_Passenger = new gui.AddFlight_Passenger();
                x = (int) ((dimension.getWidth() - addFlight_Passenger.getWidth()) / 2);
                y = (int) ((dimension.getHeight() - addFlight_Passenger.getHeight()) / 2);
                addFlight_Passenger.setLocation(x, y);
                addFlight_Passenger.setVisible(true);

                break;
            case 3:
                gui.AddPassenger addPassenger = new gui.AddPassenger();
                x = (int) ((dimension.getWidth() - addPassenger.getWidth()) / 2);
                y = (int) ((dimension.getHeight() - addPassenger.getHeight()) / 2);
                addPassenger.setLocation(x, y);
                addPassenger.setVisible(true);
                break;
            case 4:
                AddAirport addAirport = new AddAirport();
                x = (int) ((dimension.getWidth() - addAirport.getWidth()) / 2);
                y = (int) ((dimension.getHeight() - addAirport.getHeight()) / 2);
                addAirport.setLocation(x, y);
                addAirport.setVisible(true);
                break;
            case 5:
                gui.AddPlane addPlane = new gui.AddPlane();
                x = (int) ((dimension.getWidth() - addPlane.getWidth()) / 2);
                y = (int) ((dimension.getHeight() - addPlane.getHeight()) / 2);
                addPlane.setLocation(x, y);
                addPlane.setVisible(true);
                break;
            case 6:
                gui.AddCompany addCompany = new gui.AddCompany();
                x = (int) ((dimension.getWidth() - addCompany.getWidth()) / 2);
                y = (int) ((dimension.getHeight() - addCompany.getHeight()) / 2);
                addCompany.setLocation(x, y);
                addCompany.setVisible(true);
                break;
            case 7:
                gui.AddWorker addWorker = new gui.AddWorker();
                x = (int) ((dimension.getWidth() - addWorker.getWidth()) / 2);
                y = (int) ((dimension.getHeight() - addWorker.getHeight()) / 2);
                addWorker.setLocation(x, y);
                addWorker.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Please Select Table", "Add", HEIGHT);
                break;
        }

    }//GEN-LAST:event_addİdActionPerformed

    private void FlightPassengerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlightPassengerBtnActionPerformed
        GlobBtn = 2;
        try {
            showFlight_PassengerList(flight_PassengerDao.getFlightPassengerList());
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_FlightPassengerBtnActionPerformed

    private void updateİdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateİdActionPerformed
        try {
            int selectedRow = GlobTable.getSelectedRow();
            if (selectedRow < 0) {

                JOptionPane.showMessageDialog(null, "Please select someone", "Update", HEIGHT);
            }
            long selectedId = (long) GlobTable.getValueAt(selectedRow, 0);
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x, y;
            switch (GlobBtn) {
                case 1:
                    gui.Update.UpdateFlight updateFlight = new gui.Update.UpdateFlight(selectedId);
                    x = (int) ((dimension.getWidth() - updateFlight.getWidth()) / 2);
                    y = (int) ((dimension.getHeight() - updateFlight.getHeight()) / 2);
                    updateFlight.setLocation(x, y);
                    updateFlight.setVisible(true);
                    break;

                case 2:
                    gui.Update.UpdateFlight_Passenger addFlight_Passenger = new gui.Update.UpdateFlight_Passenger(selectedId);
                    x = (int) ((dimension.getWidth() - addFlight_Passenger.getWidth()) / 2);
                    y = (int) ((dimension.getHeight() - addFlight_Passenger.getHeight()) / 2);
                    addFlight_Passenger.setLocation(x, y);
                    addFlight_Passenger.setVisible(true);

                    break;
                case 3:
                    gui.Update.UpdatePassenger addPassenger = new gui.Update.UpdatePassenger(selectedId);
                    x = (int) ((dimension.getWidth() - addPassenger.getWidth()) / 2);
                    y = (int) ((dimension.getHeight() - addPassenger.getHeight()) / 2);
                    addPassenger.setLocation(x, y);
                    addPassenger.setVisible(true);
                    break;
                case 4:
                    gui.Update.UpdateAirport addAirport = new UpdateAirport(selectedId);
                    x = (int) ((dimension.getWidth() - addAirport.getWidth()) / 2);
                    y = (int) ((dimension.getHeight() - addAirport.getHeight()) / 2);
                    addAirport.setLocation(x, y);
                    addAirport.setVisible(true);
                    break;
                case 5:
                    gui.Update.UpdatePlane addPlane = new gui.Update.UpdatePlane(selectedId);
                    x = (int) ((dimension.getWidth() - addPlane.getWidth()) / 2);
                    y = (int) ((dimension.getHeight() - addPlane.getHeight()) / 2);
                    addPlane.setLocation(x, y);
                    addPlane.setVisible(true);
                    break;
                case 6:
                    gui.Update.UpdateCompany addCompany = new gui.Update.UpdateCompany(selectedId);
                    x = (int) ((dimension.getWidth() - addCompany.getWidth()) / 2);
                    y = (int) ((dimension.getHeight() - addCompany.getHeight()) / 2);
                    addCompany.setLocation(x, y);
                    addCompany.setVisible(true);
                    break;
                case 7:
                    gui.Update.UpdateWorker addWorker = new gui.Update.UpdateWorker(selectedId);
                    x = (int) ((dimension.getWidth() - addWorker.getWidth()) / 2);
                    y = (int) ((dimension.getHeight() - addWorker.getHeight()) / 2);
                    addWorker.setLocation(x, y);
                    addWorker.setVisible(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please Select Table", "Add", HEIGHT);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_updateİdActionPerformed

    private void deleteİdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteİdActionPerformed
        try {
            int selectedRow = GlobTable.getSelectedRow();
            if (selectedRow < 0) {

                JOptionPane.showMessageDialog(null, "Please select someone", "Update", HEIGHT);
            }
            long selectedId = (long) GlobTable.getValueAt(selectedRow, 0);

            switch (GlobBtn) {
                case 1:
                    deleteFlight(selectedId);
                    break;

                case 2:
                    deleteFlight_Passenger(selectedId);
                    break;
                case 3:
                    deletePassenger(selectedId);
                    break;
                case 4:
                    deleteAirport(selectedId);
                    break;
                case 5:
                    deletePlane(selectedId);
                    break;
                case 6:
                    deleteCompany(selectedId);
                    break;
                case 7:
                    deleteWorker(selectedId);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please Select Table", "Delete", HEIGHT);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_deleteİdActionPerformed

    private void GlobTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GlobTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_GlobTableMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed

        List<Model.Plane> listp = null;
        try {
            switch (GlobBtn) {
                case 1:
                    List<Flight> flights = flightDao.searchFlight(keywordTxt.getText());
                    showFlightList(flights);
                    break;
                case 2:
                    List<Model.Flight_Passenger> flight_Passengers = null;
                    break;
                case 3:
                    List<Model.Passenger> passengers = dao.searchPassenger(keywordTxt.getText());
                    showPassengerList(passengers);
                    break;
                case 4:
                    List<Model.Airport> airports = airportDao.searchPassenger(keywordTxt.getText());
                    showAirportList(airports);
                    break;
                case 5:
                    listp = planeDao.searchPlane(keywordTxt.getText());
                    showPlaneList(listp);
                    break;
                case 6:
                    List<Model.Company> companys = companyDao.searchCompany(keywordTxt.getText());
                    showCompanyList(companys);
                    break;
                case 7:
                    List<Model.Worker> workers = workerDao.searchWorker(keywordTxt.getText());
                    showWorkerList(workers);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please Select Table", "Delete", HEIGHT);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_searchBtnActionPerformed

    private void keywordTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keywordTxtKeyReleased
        searchBtnActionPerformed(null);
    }//GEN-LAST:event_keywordTxtKeyReleased

    private void AirportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AirportBtnActionPerformed
        // TODO add your handling code here:
        GlobBtn = 4;
        try {
            showAirportList(airportDao.getAirportList());
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AirportBtnActionPerformed

    private void PlaneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaneBtnActionPerformed
        // TODO add your handling code here:
        GlobBtn = 5;
        try {
            showPlaneList(planeDao.getPlaneList());
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PlaneBtnActionPerformed

    private void CompanyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompanyBtnActionPerformed
        // TODO add your handling code here:
        GlobBtn = 6;
        try {
            showCompanyList(companyDao.getCompanyList());
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CompanyBtnActionPerformed

    private void WorkerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WorkerBtnActionPerformed
        // TODO add your handling code here:
        GlobBtn = 7;
        try {
            showWorkerList(workerDao.getWorkerList());
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_WorkerBtnActionPerformed

    private void FlightStatisticsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlightStatisticsBtnActionPerformed
        // TODO add your handling code here:
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x, y;
        gui.FlightStatistics flightStatistics = new gui.FlightStatistics();
        x = (int) ((dimension.getWidth() - flightStatistics.getWidth()) / 2);
        y = (int) ((dimension.getHeight() - flightStatistics.getHeight()) / 2);
        flightStatistics.setLocation(x, y);
        flightStatistics.setVisible(true);
    }//GEN-LAST:event_FlightStatisticsBtnActionPerformed

    private void WorkerBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WorkerBtn2ActionPerformed
        // TODO add your handling code here:
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x, y;
        gui.AirportStatistics airportStatistics = new gui.AirportStatistics();
        x = (int) ((dimension.getWidth() - airportStatistics.getWidth()) / 2);
        y = (int) ((dimension.getHeight() - airportStatistics.getHeight()) / 2);
        airportStatistics.setLocation(x, y);
        airportStatistics.setVisible(true);
    }//GEN-LAST:event_WorkerBtn2ActionPerformed

    private void WorkerBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WorkerBtn3ActionPerformed
        // TODO add your handling code here:
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x, y;
        gui.TicketStatistics ticketStatistics = new gui.TicketStatistics();
        x = (int) ((dimension.getWidth() - ticketStatistics.getWidth()) / 2);
        y = (int) ((dimension.getHeight() - ticketStatistics.getHeight()) / 2);
        ticketStatistics.setLocation(x, y);
        ticketStatistics.setVisible(true);
    }//GEN-LAST:event_WorkerBtn3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AirportBtn;
    private javax.swing.JButton CompanyBtn;
    private javax.swing.JButton FlightBtn;
    private javax.swing.JButton FlightPassengerBtn;
    private javax.swing.JButton FlightStatisticsBtn;
    private javax.swing.JTable GlobTable;
    private javax.swing.JButton PassengerBtn;
    private javax.swing.JButton PlaneBtn;
    private javax.swing.JButton WorkerBtn;
    private javax.swing.JButton WorkerBtn2;
    private javax.swing.JButton WorkerBtn3;
    private javax.swing.JButton addİd;
    private java.awt.Button button1;
    private javax.swing.JButton deleteİd;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keywordTxt;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton updateİd;
    // End of variables declaration//GEN-END:variables

    private void showPassengerList(List<Model.Passenger> listPassengers) {

        try {

            DefaultTableModel model = new DefaultTableModel();
            GlobTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("Name");
            model.addColumn("Surname");
            model.addColumn("PassengerId");
            model.addColumn("Active");

            for (Model.Passenger passenger : listPassengers) {
                Object[] data = new Object[]{
                    passenger.getId(), passenger.getName(), passenger.getSurname(), passenger.getPassportId(), passenger.getActive()
                };
                model.addRow(data);
            }
            /*for (int i = 0; i <= 4; i++) {
             for (int j = 0; j <= 4; j++) {
             isCellEditable(i, j);
             }
             }*/
            GlobTable.getColumnModel().getColumn(0).setMinWidth(0);
            GlobTable.setEnabled(true);
            GlobTable.getColumnModel().getColumn(0).setMaxWidth(0);
            GlobTable.getColumnModel().getColumn(0).setWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {

        }
    }

    private void showFlightList(List<Model.Flight> listFlight) {

        try {

            DefaultTableModel model = new DefaultTableModel();
            GlobTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("Flight_No");
            model.addColumn("Departure Airport");
            model.addColumn("Arrival_airport");
            model.addColumn("Departure Date");
            model.addColumn("Arrival Date");
            model.addColumn("Company");
            model.addColumn("Plane");

            for (Model.Flight flight : listFlight) {
                Object[] data = new Object[]{
                    flight.getId(), flight.getFlight_code(), flight.getDeparture_airport().getName(),
                    flight.getArrival_airport().getName(), flight.getDeparture_date(), flight.getArrival_date(),
                    flight.getCompany().getCompany_name(), flight.getPlane().getName()
                };
                model.addRow(data);
            }
            /*for (int i = 0; i <= 4; i++) {
             for (int j = 0; j <= 4; j++) {
             isCellEditable(i, j);
             }
             }*/
            GlobTable.getColumnModel().getColumn(0).setMinWidth(0);
            GlobTable.setEnabled(true);
            GlobTable.getColumnModel().getColumn(0).setMaxWidth(0);
            GlobTable.getColumnModel().getColumn(0).setWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {

        }
    }

    private void showFlight_PassengerList(List<Model.Flight_Passenger> listFlight_Passenger) {

        try {

            DefaultTableModel model = new DefaultTableModel();
            GlobTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("Flight_No");
            model.addColumn("Passenger Full Name");
            model.addColumn("Passenger Passport");
            model.addColumn("Departure Airport");
            model.addColumn("Arrival_airport");
            model.addColumn("Departure Date");
            model.addColumn("Arrival Date");
            model.addColumn("Company");
            model.addColumn("Plane");

            for (Model.Flight_Passenger flight_Passenger : listFlight_Passenger) {
                Object[] data = new Object[]{
                    flight_Passenger.getId(), flight_Passenger.getFlight().getFlight_code(), flight_Passenger.getPassenger().getName() + " " + flight_Passenger.getPassenger().getSurname(), flight_Passenger.getPassenger().getPassportId(),
                    flight_Passenger.getFlight().getDeparture_airport().getName(), flight_Passenger.getFlight().getArrival_airport().getName(),
                    flight_Passenger.getFlight().getDeparture_date(), flight_Passenger.getFlight().getArrival_date(),
                    flight_Passenger.getFlight().getCompany().getCompany_name(), flight_Passenger.getFlight().getPlane().getName(),};
                model.addRow(data);
            }
            /*for (int i = 0; i <= 4; i++) {
             for (int j = 0; j <= 4; j++) {
             isCellEditable(i, j);
             }
             }*/
            GlobTable.getColumnModel().getColumn(0).setMinWidth(0);
            GlobTable.setEnabled(true);
            GlobTable.getColumnModel().getColumn(0).setMaxWidth(0);
            GlobTable.getColumnModel().getColumn(0).setWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {

        }
    }

    private void showAirportList(List<Model.Airport> airports) {
        try {

            DefaultTableModel model = new DefaultTableModel();
            GlobTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("Name");
            model.addColumn("Country");
            model.addColumn("Active");

            for (Model.Airport airport : airports) {
                Object[] data = new Object[]{
                    airport.getId(), airport.getName(), airport.getCountry().getName(), airport.getActive()
                };
                model.addRow(data);
            }
            /*for (int i = 0; i <= 4; i++) {
             for (int j = 0; j <= 4; j++) {
             isCellEditable(i, j);
             }
             }*/
            GlobTable.getColumnModel().getColumn(0).setMinWidth(0);
            GlobTable.setEnabled(true);
            GlobTable.getColumnModel().getColumn(0).setMaxWidth(0);
            GlobTable.getColumnModel().getColumn(0).setWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {

        }
    }

    private void showPlaneList(List<Model.Plane> planes) {
        try {

            DefaultTableModel model = new DefaultTableModel();
            GlobTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("Name");
            model.addColumn("Capacity");
            model.addColumn("Company");
            model.addColumn("Country");
            model.addColumn("Active");

            for (Model.Plane plane : planes) {
                Object[] data = new Object[]{
                    plane.getId(), plane.getName(), plane.getCapacity(), plane.getCompany().getCompany_name(), plane.getCompany().getCountry().getName(), plane.getActive()
                };
                model.addRow(data);
            }
            /*for (int i = 0; i <= 4; i++) {
             for (int j = 0; j <= 4; j++) {
             isCellEditable(i, j);
             }
             }*/
            GlobTable.getColumnModel().getColumn(0).setMinWidth(0);
            GlobTable.setEnabled(true);
            GlobTable.getColumnModel().getColumn(0).setMaxWidth(0);
            GlobTable.getColumnModel().getColumn(0).setWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {

        }
    }

    private void showCompanyList(List<Model.Company> companyList) {
        try {

            DefaultTableModel model = new DefaultTableModel();
            GlobTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("Name");
            model.addColumn("Country");
            model.addColumn("Active");

            for (Model.Company company : companyList) {
                Object[] data = new Object[]{
                    company.getId(), company.getCompany_name(), company.getCountry().getName(), company.getActive()
                };
                model.addRow(data);
            }
            /*for (int i = 0; i <= 4; i++) {
             for (int j = 0; j <= 4; j++) {
             isCellEditable(i, j);
             }
             }*/
            GlobTable.getColumnModel().getColumn(0).setMinWidth(0);
            GlobTable.setEnabled(true);
            GlobTable.getColumnModel().getColumn(0).setMaxWidth(0);
            GlobTable.getColumnModel().getColumn(0).setWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {

        }
    }

    private void showWorkerList(List<Model.Worker> workerList) {
        try {

            DefaultTableModel model = new DefaultTableModel();
            GlobTable.setModel(model);
            model.addColumn("Id");
            model.addColumn("Name");
            model.addColumn("Surname");
            model.addColumn("Passport Id");
            model.addColumn("Position");
            model.addColumn("Salary");
            model.addColumn("Active");

            for (Model.Worker worker : workerList) {
                Object[] data = new Object[]{
                    worker.getId(), worker.getName(), worker.getSurname(), worker.getPassport_id(), worker.getPosition(), worker.getSalary(), worker.getActive()
                };
                model.addRow(data);
            }
            /*for (int i = 0; i <= 4; i++) {
             for (int j = 0; j <= 4; j++) {
             isCellEditable(i, j);
             }
             }*/
            GlobTable.getColumnModel().getColumn(0).setMinWidth(0);
            GlobTable.setEnabled(true);
            GlobTable.getColumnModel().getColumn(0).setMaxWidth(0);
            GlobTable.getColumnModel().getColumn(0).setWidth(0);
            model.fireTableDataChanged();
        } catch (Exception e) {

        }
    }

    private void deletePassenger(long selectedId) {
        try {
            //Passenger passenger = dao.getPassengerById(selectedId);
            int isDel = JOptionPane.showConfirmDialog(null, "Are you sure to delete ", "Delete Passenger", JOptionPane.YES_NO_OPTION);
            if (isDel == JOptionPane.YES_OPTION) {
                boolean isDelete = dao.deletePassenger(selectedId);
                if (isDelete) {
                    JOptionPane.showMessageDialog(null, "Passsenfer has been deleted", "Delete Passenger", HEIGHT);
                } else {
                    JOptionPane.showMessageDialog(null, "Error!", "Delete Passenger", HEIGHT);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteWorker(long selectedId) {
        try {
            //Worker worker = workerDao.getWorkerById(selectedId);
            int isDel = JOptionPane.showConfirmDialog(null, "Are you sure to delete ", "Delete Worker", JOptionPane.YES_NO_OPTION);
            if (isDel == JOptionPane.YES_OPTION) {
                boolean isDelete = workerDao.deleteWorker(selectedId);
                if (isDelete) {
                    JOptionPane.showMessageDialog(null, "Worker has been deleted", "Delete Worker", HEIGHT);
                } else {
                    JOptionPane.showMessageDialog(null, "Error!", "Delete Worker", HEIGHT);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteFlight_Passenger(long selectedId) {
        try {
            //Flight_Passenger flight_Passenger = flight_PassengerDao.getFlight_PassengerById(selectedId);
            int isDel = JOptionPane.showConfirmDialog(null, "Are you sure to delete ", "Delete Flight Passenger", JOptionPane.YES_NO_OPTION);
            if (isDel == JOptionPane.YES_OPTION) {
                boolean isDelete = flight_PassengerDao.deleteFlight_Passenger(selectedId);
                if (isDelete) {
                    JOptionPane.showMessageDialog(null, "Flight Passenger has been deleted", "Delete Flight Passenger", HEIGHT);
                } else {
                    JOptionPane.showMessageDialog(null, "Error!", "Delete Flight Passenger", HEIGHT);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteFlight(long selectedId) {
        try {
            //Flight flight = flightDao.getFlightById(selectedId);
            int isDel = JOptionPane.showConfirmDialog(null, "Are you sure to delete ", "Delete Flight ", JOptionPane.YES_NO_OPTION);
            if (isDel == JOptionPane.YES_OPTION) {
                boolean isDelete = flightDao.deleteFlight(selectedId);
                if (isDelete) {
                    JOptionPane.showMessageDialog(null, "Flight has been deleted", "Delete Flight ", HEIGHT);
                } else {
                    JOptionPane.showMessageDialog(null, "Error!", "Delete Flight", HEIGHT);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteAirport(long selectedId) {
        try {
            // Airport airport = airportDao.getAirportById(selectedId);
            int isDel = JOptionPane.showConfirmDialog(null, "Are you sure to delete ", "Delete Airport ", JOptionPane.YES_NO_OPTION);
            if (isDel == JOptionPane.YES_OPTION) {
                boolean isDelete = airportDao.deleteAirport(selectedId);
                if (isDelete) {
                    JOptionPane.showMessageDialog(null, "Airport has been deleted", "Delete Airport ", HEIGHT);
                } else {
                    JOptionPane.showMessageDialog(null, "Error!", "Delete Airport", HEIGHT);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deletePlane(long selectedId) {
        try {
            //  Plane plane = planeDao.getPlaneById(selectedId);
            int isDel = JOptionPane.showConfirmDialog(null, "Are you sure to delete ", "Delete Plane ", JOptionPane.YES_NO_OPTION);
            if (isDel == JOptionPane.YES_OPTION) {
                boolean isDelete = planeDao.deletePlane(selectedId);
                if (isDelete) {
                    JOptionPane.showMessageDialog(null, "Plane has been deleted", "Delete Plane ", HEIGHT);
                } else {
                    JOptionPane.showMessageDialog(null, "Error!", "Delete Plane", HEIGHT);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteCompany(long selectedId) {
        try {
            // Company company = companyDao.getCompanyById(selectedId);
            int isDel = JOptionPane.showConfirmDialog(null, "Are you sure to delete ", "Delete Company ", JOptionPane.YES_NO_OPTION);
            if (isDel == JOptionPane.YES_OPTION) {
                boolean isDelete = companyDao.deleteCompany(selectedId);
                if (isDelete) {
                    JOptionPane.showMessageDialog(null, "Company has been deleted", "Delete Company ", HEIGHT);
                } else {
                    JOptionPane.showMessageDialog(null, "Error!", "Delete Company", HEIGHT);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MainFrameEsas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
