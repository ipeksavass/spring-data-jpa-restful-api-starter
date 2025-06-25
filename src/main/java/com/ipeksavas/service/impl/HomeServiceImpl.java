package com.ipeksavas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipeksavas.dto.DtoHome;
import com.ipeksavas.dto.DtoRoom;
import com.ipeksavas.entities.Home;
import com.ipeksavas.entities.Room;
import com.ipeksavas.repository.HomeRepository;
import com.ipeksavas.service.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService{

	@Autowired
	private HomeRepository homeRepository;
	
	@Override
	public DtoHome findHomeById(Long id) {
		DtoHome dtoHome = new DtoHome();
		
		 Optional<Home> optional = homeRepository.findById(id);
		 if(optional.isEmpty()) {
			 return null;
		 }
		 Home dbHome = optional.get();
		 List<Room> dbRooms = optional.get().getRoom();
		 BeanUtils.copyProperties(dbHome, dtoHome);
		 
		 if (dbRooms!=null && !dbRooms.isEmpty()) {
			 for (Room room : dbRooms) {
				 DtoRoom dtoRoom = new DtoRoom();
				 BeanUtils.copyProperties(room, dtoRoom);
				 dtoHome.getRooms().add(dtoRoom);
				}
		}
		return dtoHome;
	}
	 
}
