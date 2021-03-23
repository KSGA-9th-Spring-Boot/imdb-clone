package io.kimleang.springmvc.service.watchlist;

import io.kimleang.springmvc.dto.mapper.WatchListMapper;
import io.kimleang.springmvc.dto.model.UserDto;
import io.kimleang.springmvc.dto.model.WatchListDto;
import io.kimleang.springmvc.model.watchlist.WatchList;
import io.kimleang.springmvc.repository.WatchListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WatchListServiceImpl implements WatchListService {

    @Autowired
    private WatchListRepository watchListRepository;

    @Autowired
    private WatchListMapper watchListMapper;

    @Override
    public boolean save(WatchListDto watchListDto) {
        return watchListRepository.save(watchListDto.getMovieDto().getId(), watchListDto.getUserDto().getId());
    }

    @Override
    public boolean delete(WatchListDto watchListDto) {
        return watchListRepository.delete(watchListDto.getMovieDto().getId(), watchListDto.getUserDto().getId());
    }

    @Override
    public List<WatchListDto> findAllWatchListByUserId(UserDto userDto) {
        if(userDto != null) {
            List<WatchList> watchLists = watchListRepository.findAllWatchListByUserId(userDto.getId());
            return watchListMapper.watchListsToWatchListDtos(watchLists);
        }
        return new ArrayList<>();
    }

}
