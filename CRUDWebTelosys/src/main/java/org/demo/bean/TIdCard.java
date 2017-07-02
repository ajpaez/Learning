/*
 * Created on 4 mar 2017 ( Time 18:53:43 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class TIdCard implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Long id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 255 )
    private String idNumber;


    private Date issueDate;


    private Integer valid;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Long id ) {
        this.id = id ;
    }

    public Long getId() {
        return this.id;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setIdNumber( String idNumber ) {
        this.idNumber = idNumber;
    }
    public String getIdNumber() {
        return this.idNumber;
    }

    public void setIssueDate( Date issueDate ) {
        this.issueDate = issueDate;
    }
    public Date getIssueDate() {
        return this.issueDate;
    }

    public void setValid( Integer valid ) {
        this.valid = valid;
    }
    public Integer getValid() {
        return this.valid;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(idNumber);
        sb.append("|");
        sb.append(issueDate);
        sb.append("|");
        sb.append(valid);
        return sb.toString(); 
    } 


}