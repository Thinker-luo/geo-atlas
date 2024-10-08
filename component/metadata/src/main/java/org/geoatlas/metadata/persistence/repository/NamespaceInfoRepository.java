package org.geoatlas.metadata.persistence.repository;

import org.geoatlas.metadata.model.NamespaceInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author: <a href="mailto:thread.zhou@gmail.com">Fuyi</a>
 * @time: 2024/4/27 12:29
 * @since: 1.0
 **/
public interface NamespaceInfoRepository extends PagingAndSortingRepository<NamespaceInfo, Long> {

    NamespaceInfo findFirstByName(String name);

    boolean existsByName(String name);

    Page<NamespaceInfo> findAllByNameContaining(String name, Pageable pageable);

    List<NamespaceInfo> findAll();

    @Query("select n.* from ga_namespace_info n left join ga_feature_layer_info f on n.id = f.namespace_id where f.id = :featureLayerId")
    NamespaceInfo findByFeatureLayerId(Long featureLayerId);
}
