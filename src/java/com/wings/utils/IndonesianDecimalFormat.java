/*
 * EnglishDecimalFormat.java
 *
 * Created on July 5, 2008, 9:22 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.wings.utils;

import java.text.DecimalFormat;

/**
 *
 * @author Ahmad Husain
 */
public class IndonesianDecimalFormat {
    
    private String[] STRANGKA = {"", "satu ", "dua ", "tiga ", "empat ", "lima ", "enam ", "tujuh ", "delapan ", "sembilan "};
    private String[] STRDESIMAL = {"puluh ", "ratus ", "ribu ", "juta ", "milyar ", "trilyun ", "bilyun "};

    private String m_Text;
    
    public IndonesianDecimalFormat() {        
    }
    
    public String convert(String m_Text) {
        Float f_text = new Float(m_Text);
        DecimalFormat indMoneyFormat = new DecimalFormat("###");
        String str_text = indMoneyFormat.format(f_text);
        setText(str_text);
        return this.FormatTerbilang(str_text);
    }
    public String getText() {
        return m_Text;
    }
    
    public void setText(String m_Text) {
        this.m_Text = m_Text;
    }
    
    private String Satuan(String s, int x)
    {
        String m_hasil = "";

        try {
           int i = (int) s.charAt(x) - 0x30 ;
           if (i == 1)
               m_hasil = "se";
           else
               m_hasil = STRANGKA[i];           
        } 
        catch (Throwable t) {}
        finally {}
        return m_hasil;
    }
    
    private String Puluhan(String s, int x)
    {
        String m_hasil = "";

        try {
            int i = (int)s.charAt(x) - 0x30;
            int j = (int)s.charAt(x + 1) - 0x30;

            switch (i)
            {
                case 0:
                    m_hasil = STRANGKA[j];
                    break;
                case 1:
                    switch (j)
                    {
                        case 0:
                            m_hasil = "sepuluh ";
                            break;
                        case 1:
                            m_hasil = "sebelas ";
                            break;
                        default:
                            {
                                m_hasil = STRANGKA[j];
                                m_hasil += "belas ";
                            } break;
                     } break;
                default:
                    {
                        m_hasil = STRANGKA[i];
                        m_hasil = m_hasil + STRDESIMAL[0] + STRANGKA[j];
                     } break;
                }
        } 
        catch (Throwable t) {}
        finally {}

        return m_hasil;
    }
    
    private String Ratusan(String s, int x)
    {
            String m_hasil = "";
            
            try {           
                int i = (int)s.charAt(x) - 0x30;

                switch (i)
                {
                    case 0:
                        m_hasil = Puluhan(s, x + 1);
                        break;
                    default:
                        {
                            m_hasil = (i == 1) ? "se" : STRANGKA[i];
                            m_hasil += STRDESIMAL[1];
                            m_hasil += Puluhan(s, x + 1);
                        } break;
                }
            } 
            catch (Throwable t) {}
            finally {}
            return m_hasil;
     }

     private boolean SemuaNol(String s, int x)
     {
            int i = 0, j = 0, k = 0;
            try {
                i = (int) s.charAt(x - 1) - 0x30;
                j = (int) s.charAt(x - 2) - 0x30;
                k = (int) s.charAt(x - 3) - 0x30;            
            } 
            catch (Throwable t) {}
            finally {}
            return ((i == 0) && (j == 0) && (k == 0));
     }
     
     public String FormatTerbilang(String s)
     {
            String m_temp = s;
            String m_hasil = "";
            
            
            if (m_temp.length() == 0)
            {
                return "";
            }

            if (m_temp.length() > 18) 
            {
                return "Cannot convert this string.";
            }

            if (m_temp.indexOf(",") > 0)
            {
                m_temp = m_temp.replace(",", "");
            }

            String m_hasilSen = "";

            if (m_temp.indexOf(".") > 0)
            {
                String m_sen = m_temp.substring(m_temp.indexOf(".") + 1);

                m_temp = m_temp.substring(0, m_temp.length() - (m_sen.length() + 1));

                // Perbaikan Satuan(m_sen, 0) != "" menjadi Satuan(m_sen, 0).isEmpty()
                // tidak kompatible di versi 6.x
                m_hasilSen = (m_sen.length() == 1) ? ((Satuan(m_sen, 0).isEmpty()) ? Satuan(m_sen, 0) + "" : "") : ((Puluhan(m_sen, 0).isEmpty()) ? Puluhan(m_sen, 0) + "" : "");
            }
            
            int len = m_temp.length();

            if (m_temp.length() == 1)
            {
                if ((int)m_temp.charAt(0) - 0x30 == 0)
                    m_hasil = "nol ";
                else
                    m_hasil = STRANGKA[(int)m_temp.charAt(0) - 0x30];

                return m_hasil + "";
            }

            int counter = 0;
            int sisa = len % 3;

            switch (sisa)
            {
                case 2:
                    m_hasil = Puluhan(m_temp, 0);
                    counter = 2;
                    break;
                case 1:
                    m_hasil = Satuan(m_temp, 0);
                    counter = 1;
                    break;
                case 0:
                    m_hasil = Ratusan(m_temp, 0);
                    counter = 3;
                    break;
            }

            int x = (sisa == 0) ? (len / 3) : (len / 3) + 1;
            while (counter < len)
            {
                if (!SemuaNol(m_temp, counter))
                    m_hasil += STRDESIMAL[x];
                
                if (m_hasil.substring(0, 4).matches("seju"))
                    m_hasil = "satu juta ";
                else 
                    if (m_hasil.substring(0, 4).matches("semi")) 
                        m_hasil = "satu milyar ";
                else 
                    if (m_hasil.substring(0, 4).matches("setr")) 
                        m_hasil = "satu trilyun ";
                else 
                    if (m_hasil.substring(0, 4).matches("sebi")) 
                    m_hasil = "satu bilyun ";
 
                m_hasil += Ratusan(m_temp, counter);
                counter += 3;
                x--;
            }
                       
            return m_hasil  + "" + m_hasilSen;
     }
}
