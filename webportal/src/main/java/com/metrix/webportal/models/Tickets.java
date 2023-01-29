package com.metrix.webportal.models;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
//1. Annotation for indicating this is an entity class
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tickets implements Serializable {
    //2. Annotation for indicating this field is a primary key of the class
   @Id
    //3. Annotation for indicating this field will auto generate seq. number when insert into DB
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //4a. Annotation for checking this field is not blank, if blank, view will show error message "Operator must be provided!"
    @NotBlank(message ="Operator must be provided!")
    //5a. Annotation for checking this field cannot exceed 100 characters, if not, view will show error message "Operator must less than 100 characters!"
    @Size(min = 3, max = 100, message = "Operator must less than 100 characters!")
    //6a. Annotation indicating this field in DB is not nullable
    @NonNull
    private String operator;

    //4b. Annotation for checking this field is not blank, if blank, view will show error message "QR Code must be provided!"
    @NotBlank(message ="QR Code must be provided!")
   
    //5b. Annotation for checking this field cannot exceed 255 characters, if not, view will show error message "QR Code must less than 255 characters!"
    @Size(min = 3, max = 255,message ="QR Code must less than 255 characters!")
  
    //6b. Annotation indicating this field in DB is not nullable and a unique field    
    @NotNull

   
    private String qrcode;

    private boolean isClaimed;

    //6c. Annotation indicating this field in DB is not nullable
    @NotNull 
    //7a. Annotation for checking this field value should be a past date, if not, view will show error message "Sell date time must be a past date time"
    @Past(message ="Sell date time must be a past date time" )
    private Date sellDtm;

    //6d. Annotation indicating this field in DB is not nullable
    @NotNull

    //7b. Annotation for checking this field value should be a past date, if not, view will show error message "Claim date time must be a past date time"
    @Past(message = "Claim date time must be a past date time")
    
    private Date claimDtm;

    @ManyToOne(fetch = FetchType.LAZY)
    private Events event;    
}
