package org.pallas.alapozo.ViewModel;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author bardo
 */

@Getter @Setter
public class SmallAlkalmazottView {
    private int id;
    private int alkKod;
    private String alkNev;
    private String beosztas;
    private Integer fizetes;
    private Integer premium;
    private Date belepes;
}
