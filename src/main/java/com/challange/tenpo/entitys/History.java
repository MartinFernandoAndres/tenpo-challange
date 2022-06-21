package com.challange.tenpo.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "History")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    @Column(name = "endpoint")
    private String endpoint;

    @Column(name = "statuscode")
    private int statusCode;

    @Column(name = "time")
    private String timeStamp;

    @Column(name = "method")
    private String method;

}
