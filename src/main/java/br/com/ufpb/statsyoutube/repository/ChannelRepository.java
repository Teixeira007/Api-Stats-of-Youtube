package br.com.ufpb.statsyoutube.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufpb.statsyoutube.model.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long>{    
}
