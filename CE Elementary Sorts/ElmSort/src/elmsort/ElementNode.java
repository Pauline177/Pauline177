/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elmsort;



/**
 *
 * @author dhunter3
 */
public class ElementNode implements Comparable{
    private String Name;
    private String Abbr;
    private Integer Number;
    private Double Weight;
    
    public ElementNode(String n, String a, Integer nu, Double w){
        Name = n;
        Abbr = a;
        Number = nu;
        Weight = w;        
    }
    
    public String getName(){
        return Name;
    }
    
    public String getAbbr(){
        return Abbr;
    }
    
    public Double getWeight(){
        return Weight;
    }
    
    public Integer getNumber(){
        return Number;
    }

    @Override
    public int compareTo(Object arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
