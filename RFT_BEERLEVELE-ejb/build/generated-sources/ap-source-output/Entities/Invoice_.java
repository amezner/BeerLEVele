package Entities;

import Entities.Customer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-25T19:49:18")
@StaticMetamodel(Invoice.class)
public class Invoice_ { 

    public static volatile SingularAttribute<Invoice, Date> date;
    public static volatile SingularAttribute<Invoice, Customer> customerId;
    public static volatile SingularAttribute<Invoice, Integer> discount;
    public static volatile SingularAttribute<Invoice, Integer> invoicenumber;

}