package com.tca.entitis;

import jakarta.persistence.*;


@Entity(name="student")
public class Student
{
    @Id
    @TableGenerator(name ="tg", table = "mytab",pkColumnName = "id",pkColumnValue = "1",valueColumnName = "next_val",initialValue = 101,allocationSize = 1)
                    //name(table generator name for hibernate), table(table name for MySql), pkColumnName(Pkey col name),pkColumnValue(PK starting value),
                    //valueColumnName(name for column for fetching values for table)
                    //initializeValue(Starting value)
                    //allocationSize(growing nature)
    @GeneratedValue(strategy= GenerationType.TABLE,generator = "tg")
                    //generator(to tell the hibernate which generator is going to be used for generationType.TABLE)
    private Integer rno;
    private String name;
    private Double per;

    public Integer getRno()
    {
        return rno;
    }
    public void setRno(Integer rno)
    {
        this.rno = rno;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getPer()
    {
        return per;
    }

    public void setPer(Double per) {
        this.per = per;
    }
}
