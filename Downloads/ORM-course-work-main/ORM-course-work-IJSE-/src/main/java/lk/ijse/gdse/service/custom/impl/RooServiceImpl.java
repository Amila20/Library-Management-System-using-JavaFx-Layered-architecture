package lk.ijse.gdse.service.custom.impl;

import lk.ijse.gdse.dao.custom.impl.RoomsDAOImpl;
import lk.ijse.gdse.dto.RoomsDTO;
import lk.ijse.gdse.entity.Rooms;
import lk.ijse.gdse.entity.Student;

import java.util.List;

public class RooServiceImpl {

    RoomsDAOImpl  roomsDAO = new RoomsDAOImpl();

    public boolean save(RoomsDTO roomsDTO) throws Exception {
        roomsDAO.save(new Rooms(
                roomsDTO.getRoom_type_id(),
                roomsDTO.getType(),
                roomsDTO.getKey_money(),
                roomsDTO.getQty()
        ));

        return true;
    }

    public List<Rooms> getAll() {
        return roomsDAO.getAll();
    }

    public  List<Rooms> getAllIds(){
        return roomsDAO.getRoomIds();
    }

}
