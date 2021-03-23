package io.kimleang.springmvc.service.watchlist;

import io.kimleang.springmvc.dto.model.UserDto;
import io.kimleang.springmvc.dto.model.WatchListDto;

import java.util.List;

public interface WatchListService {
    boolean save(WatchListDto watchListDto);
    boolean delete(WatchListDto watchListDto);
    List<WatchListDto> findAllWatchListByUserId(UserDto userDto);
}
