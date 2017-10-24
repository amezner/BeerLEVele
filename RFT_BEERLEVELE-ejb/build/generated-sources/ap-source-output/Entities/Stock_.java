package Entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-23T22:31:58")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, Integer> sellingprice;
    public static volatile SingularAttribute<Stock, String> name;
    public static volatile SingularAttribute<Stock, String> description;
    public static volatile SingularAttribute<Stock, Integer> id;
    public static volatile SingularAttribute<Stock, String> type;
    public static volatile SingularAttribute<Stock, Integer> purchaseprice;
    public static volatile SingularAttribute<Stock, Integer> onstockquantity;

}