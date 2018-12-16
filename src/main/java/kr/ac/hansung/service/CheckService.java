package kr.ac.hansung.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CheckDAO;
import kr.ac.hansung.model.Check;
import kr.ac.hansung.model.Offer;


@Service
public class CheckService {

	@Autowired
	private CheckDAO checkDAO;
	public List<Check> getCurrent() {
		return checkDAO.getChecks();
		
	}
	/*public void insert(Offer offer) {
		checkDAO.insert(offer);
		
	}*/

}