package br.com.ufpb.statsyoutube.repository;

import br.com.ufpb.statsyoutube.model.ChannelOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ufpb.statsyoutube.model.Channel;

@Repository
public interface ChannelRepository extends CrudRepository<ChannelOrigin, Long>, JpaRepository<ChannelOrigin, Long>{
}
