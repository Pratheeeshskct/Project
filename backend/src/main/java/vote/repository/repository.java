package vote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import vote.entity.data;
import vote.entity.mainTable;

@Repository
public interface repository extends JpaRepository<mainTable, Integer> {

	@Query(value = "select count(name) from main_table where name= ?1", nativeQuery = true)
	public int isAlreadyPresent(String s);

	@Query(value = "select * from main_table", nativeQuery = true)
	public List<mainTable> allUsers();


}
