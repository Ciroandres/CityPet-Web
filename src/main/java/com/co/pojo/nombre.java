
package com.co.pojo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="nombre")

public class nombre implements Serializable{
    
    @Id
    private String idnombre;
    private String apellido1;
    private String apellido2;
   
   
    
  
}
