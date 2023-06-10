package br.com.joao.simoes.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <O, D> D parseObject(O origin, Class<D> destination) {
		
		
		return mapper.map(origin, destination);
		
	}
	
	public static <O, D> List<D> parseListObject(List<O> listOrigin, Class<D> destination) {
		
		List<D> listDestination = new ArrayList<D>();
		
		for (O origin : listOrigin) {
			
			listDestination.add(mapper.map(origin, destination));
			
		}
		
		return listDestination;
		
	}
	
}
