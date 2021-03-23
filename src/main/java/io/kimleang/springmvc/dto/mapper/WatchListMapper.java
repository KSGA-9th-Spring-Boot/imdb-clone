package io.kimleang.springmvc.dto.mapper;

import io.kimleang.springmvc.dto.model.WatchListDto;
import io.kimleang.springmvc.model.watchlist.WatchList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WatchListMapper {

    @Mapping(source = "movie", target = "movieDto")
    WatchListDto watchListToWatchListDto(WatchList watchList);

    @Mapping(source = "movieDto", target = "movie")
    WatchList watchListDtoToWatchList(WatchListDto watchListDto);

    List<WatchListDto> watchListsToWatchListDtos(List<WatchList> watchList);
    List<WatchList> watchListDtosToWatchLists(List<WatchListDto> watchListDto);

}
