package michael.dev.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import michael.dev.app.model.Banner;

@Repository
public interface BannersRepository extends CrudRepository<Banner, Integer> {

	// select * from Banners where estatus = ? order by id desc 
		public List<Banner> findByEstatusOrderByIdDesc(String estatus);
}
