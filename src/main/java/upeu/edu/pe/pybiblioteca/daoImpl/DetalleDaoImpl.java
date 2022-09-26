package upeu.edu.pe.pybiblioteca.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import upeu.edu.pe.pybiblioteca.dao.Operaciones;
import upeu.edu.pe.pybiblioteca.entity.Detalle;
import upeu.edu.pe.pybiblioteca.entity.Libro;
import upeu.edu.pe.pybiblioteca.entity.Prestamo;
@Component
public class DetalleDaoImpl implements Operaciones<Detalle> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Detalle t) {
		// TODO Auto-generated method stub

		String SQL = "INSERT INTO delalle (iddetalle, idlibro, idprestamo) VALUES (?,?,?)";
		return jdbcTemplate.update(SQL, t.getIddetalle(), t.getIdlibro(), t.getIdprestamo());
	}

	@Override
	public int update(Detalle t) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE detalle SET idlibro = ? WHERE (iddetalle = ?)";
		return jdbcTemplate.update(SQL, t.getIddetalle());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL="DELETE FROM detalle WHERE iddetalle = ?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Detalle read(int id) {
		// TODO Auto-generated method stub
		try {
			Detalle det = jdbcTemplate.queryForObject("SELECT *FROM detalle WHERE iddetalle=?",
					BeanPropertyRowMapper.newInstance(Detalle.class), id);
			return det;
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}


	@Override
	public List<Detalle> reaAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from detalle", BeanPropertyRowMapper.newInstance(Detalle.class));
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		String SQL = "select v.idlibro, p.prestamo from detalle as d "
				+ "inner join libro as v on d.idlibro= v.idlibro "
				+ "inner join prestamo as p on d.idprestamo= p.idprestamo ";
		return jdbcTemplate.queryForList(SQL);
	}

	

}
