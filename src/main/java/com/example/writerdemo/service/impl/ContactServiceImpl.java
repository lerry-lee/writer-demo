package com.example.writerdemo.service.impl;

import com.example.writerdemo.entity.Contact;
import com.example.writerdemo.mapper.ContactMapper;
import com.example.writerdemo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/01/02
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public Boolean save(Contact contact) {
        try {
            contactMapper.insert(contact);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
