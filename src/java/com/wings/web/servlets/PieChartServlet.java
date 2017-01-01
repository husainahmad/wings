/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wings.web.servlets;

import com.wings.adapter.StrutsJobsheetDelegate;
import com.wings.persistence.Jobsheet;
import com.wings.persistence.JobsheetDetail;
import com.wings.web.struts.forms.MonthYearForm;
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Ahmad Husain
 */
public class PieChartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String _year;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        OutputStream out = response.getOutputStream(); /* Get the output stream from the response object */
        try {
                
                String year = request.getParameter("year");
                
                int iyear = Integer.parseInt(year);
                _year = String.valueOf(iyear);
                MonthYearForm monthYearForm = new MonthYearForm();
                monthYearForm.setYear(new Integer(iyear));
                List reports = StrutsJobsheetDelegate.selectChartByYear(monthYearForm);
                XYDataset dataset = createDataset(reports);         
                JFreeChart mychart = createChart(dataset); 
                response.setContentType("image/png"); /* Set the HTTP Response Type */
                /* Send a big chart back to the browser */
                ChartUtilities.writeChartAsPNG(out, mychart, 640, 480);/* Write the data to the output stream */
                
        }
        catch (Exception e) {
                System.err.println(e.toString()); /* Throw exceptions to log files */
        }
        finally {
                out.close();/* Close the output stream */
        }
    }

     private XYDataset createDataset(List reports) {
         JobsheetDetail jobsheet = null;
         JobsheetDetail jobsheetin = null;       
                final XYSeries series1 = new XYSeries("Billing IDR");
                for (int i=0; i<12; i++) {                   
                    try {
                         boolean found = false;
                         for (int j=0; j<reports.size(); j++) {
                             jobsheet = (JobsheetDetail) reports.get(j);
                             if ((i+1) == Integer.parseInt(jobsheet.getJobNo())) {
                                 found = true;
                                 jobsheetin = jobsheet;
                             }                             
                         }                             
                         if (found) {
                             System.out.println( i+ ":::" + jobsheetin.getTotalBillingIDR());
                             series1.add(Integer.parseInt(jobsheetin.getJobNo()), jobsheetin.getTotalBillingIDR());       
                         } else {
                             System.out.println( i+ ":::" + 0.0);
                             series1.add(i+1, 0.0);     
                         }
                    } catch (Exception e) {
                        series1.add(i+1, 0.0);                    
                    }                    
                }
                
                jobsheet = null;
                
                final XYSeries series2 = new XYSeries("Billing USD");
                for (int i=0; i<12; i++) {                    
                    try {           
                         boolean found = false;
                         for (int j=0; j<reports.size(); j++) {
                             jobsheet = (JobsheetDetail) reports.get(j);
                             if ((i+1) == Integer.parseInt(jobsheet.getJobNo())) {                                  
                                  found = true;
                                  jobsheetin = jobsheet;
                             } 
                         }                                 
                         if (found) {
                             System.out.println( i+ ":::" + (jobsheetin.getTotalBillingUSD().doubleValue() * 10000));
                             series2.add(Integer.parseInt(jobsheetin.getJobNo()), jobsheetin.getTotalBillingUSD().doubleValue() * 10000);  
                         } else {
                             series2.add(i+1, 0.0);    
                         }
                    } catch (Exception e) {
                        series2.add(i+1, 0.0);                    
                    }
                }
                
                jobsheet = null;
                
                final XYSeries series3 = new XYSeries("Exp IDR");
                for (int i=0; i<12; i++) {                    
                     try {                   
                         boolean found = false;
                         for (int j=0; j<reports.size(); j++) {
                             jobsheet = (JobsheetDetail) reports.get(j);
                             if ((i+1) == Integer.parseInt(jobsheet.getJobNo())) {
                                 found = true;
                                 jobsheetin = jobsheet;
                             }                             
                         }        
                         if (found) {
                             System.out.println( i+ ":::" + jobsheetin.getTotalExpensesIDR().doubleValue());
                             series3.add(Integer.parseInt(jobsheetin.getJobNo()), jobsheetin.getTotalExpensesIDR().doubleValue());  
                         } else {
                             series3.add(i+1, 0.0);    
                         }
                     } catch (Exception e) {
                         series3.add(i+1, 0.0); 
                     }
                }
                
                jobsheet = null;
                
                final XYSeries series4 = new XYSeries("Exp USD");
                for (int i=0; i<12; i++) {                    
                    try {                
                        boolean found = false;
                        for (int j=0; j<reports.size(); j++) {
                             jobsheet = (JobsheetDetail) reports.get(j);
                             if ((i+1) == Integer.parseInt(jobsheet.getJobNo())) {                                 
                                 found = true;
                                 jobsheetin = jobsheet;
                             }                             
                        }           
                        if (found) {
                            System.out.println( i+ ":::" + (jobsheetin.getTotalExpensesUSD().doubleValue() * 10000));
                            series4.add(Integer.parseInt(jobsheetin.getJobNo()), jobsheetin.getTotalExpensesUSD().doubleValue() * 10000);
                        } else {
                            series4.add(i+1, 0.0);    
                        }
                    } catch (Exception e) {
                        series4.add(i+1, 0.0);                    
                    }
                }
                
                final XYSeriesCollection dataset = new XYSeriesCollection();
                dataset.addSeries(series1);
                dataset.addSeries(series2);
                dataset.addSeries(series3);
                dataset.addSeries(series4);
                
                return dataset;
     }
    private JFreeChart createChart(final XYDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "Chart Performance Report " + _year,      // chart title
            "Month",                      // x axis label
            "Rev",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);


        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        //renderer.setSeriesLinesVisible(0, false);
        //renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.
                
        return chart;
        
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
