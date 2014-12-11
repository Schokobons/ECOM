/**
 * 
 */
package com.bean;


import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 * @author MORJARET fixe
 *
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean
{
    private String name = "Franc";
    private String password;


    public String getName ()
    {
        return name;
    }


    public void setName (final String name)
    {
        this.name = name;
    }


    public String getPassword ()
    {
        return password;
    }


    public void setPassword (final String password)
    {
        this.password = password;
    }
}