/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eway.model;

/**
 *
 * @author ASUS
 */
public class Profile {
    private String StuName;
    private String StuId;
    private String Falculty;
    private String BranchOf;
    
    public Profile(){
        
    }

    public Profile(String StuName, String StuId, String Falculty, String BranchOf) {
        this.StuName = StuName;
        this.StuId = StuId;
        this.Falculty = Falculty;
        this.BranchOf = BranchOf;
    }

    public String getStuName() {
        return StuName;
    }

    public String getStuId() {
        return StuId;
    }

    public String getFalculty() {
        return Falculty;
    }

    public String getBranchOf() {
        return BranchOf;
    }

    public void setStuName(String StuName) {
        this.StuName = StuName;
    }

    public void setStuId(String StuId) {
        this.StuId = StuId;
    }

    public void setFalculty(String Falculty) {
        this.Falculty = Falculty;
    }

    public void setBranchOf(String BranchOf) {
        this.BranchOf = BranchOf;
    }

    @Override
    public String toString() {
        return "StudentName: " + StuName +"\n"+ "StudentId: " + StuId +"\n"+ "Falcult: " + Falculty +"\n"+ "BranchOf :" + BranchOf ;
    }
    
}
