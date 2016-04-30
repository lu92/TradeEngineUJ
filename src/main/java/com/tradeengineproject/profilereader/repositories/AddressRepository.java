package com.tradeengineproject.profilereader.repositories;

import com.tradeengineproject.profilereader.domain.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class AddressRepository
{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void save(Address address)
    {
        hibernateTemplate.saveOrUpdate(address);
    }

    public void delete(Address address)
    {
        hibernateTemplate.delete(address);
    }

    public Address get(int id)
    {
        return hibernateTemplate.get(Address.class, id);
    }

    public List<Address> getAll()
    {
        return (List<Address>) hibernateTemplate.findByNamedQuery("SELECT * FROM ADDRESS");
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
    {
        this.hibernateTemplate = hibernateTemplate;
    }
}
