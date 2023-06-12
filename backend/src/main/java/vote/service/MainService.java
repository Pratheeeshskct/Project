package vote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vote.entity.mainTable;
import vote.repository.repository;

@Service
public class MainService {
	@Autowired
	public repository ur;

    public mainTable post4(mainTable amodel6)
    {
     return ur.save(amodel6);
    }
    
    public List<mainTable> get4()
    {
     return ur.findAll();
    }
    
    public mainTable put4(mainTable amodel7)
    {
     return ur.saveAndFlush(amodel7);
    }
    
    public void delete4(int id)
    {
     ur.deleteById(id);
    }
}