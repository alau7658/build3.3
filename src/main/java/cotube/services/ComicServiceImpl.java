package cotube.services;

import cotube.domain.Comic;
import cotube.repositories.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComicServiceImpl implements ComicService {

    @Autowired
    private ComicRepository comicRepository;

    @Autowired
    public void setProductRepository(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }


    @Override
    public Comic addComic(Comic comic) {
        return comicRepository.save(comic);
    }

    @Override
    public List<Comic> getAllComics() {

        List<Comic> comics = (List<Comic>) comicRepository.findAll();
        return comics;
    }

    @Override
    public void deleteComic(Comic comic) {
        comicRepository.delete(comic);
    }

    @Override
    public List<Comic> searchComicsByTitle(String title){
        //List<Comic> comics = comicRepository.findAll();
        List<Comic> comics = (List<Comic>) comicRepository.findAll();
        //System.out.println(title);
        List<Comic> result = new ArrayList<Comic>();
        for (Comic com: comics){

            if (com.getTitle().contains((CharSequence)title)){
                result.add(com);
            }
            System.out.println(com.getTitle());
            System.out.println(title);
        }
        return result;
    }

    public List<Comic> searchComicsByTitlePublic(String title){
        //List<Comic> comics = comicRepository.findAll();
        List<Comic> comics = (List<Comic>) comicRepository.findAll();
        //System.out.println(title);
        List<Comic> result = new ArrayList<Comic>();
        for (Comic com: comics){

            if (com.getTitle().contains((CharSequence)title)&&(com.getStatus()==1||com.getStatus()==3)){
                result.add(com);
            }
            System.out.println(com.getTitle());
            System.out.println(title);
        }
        return result;
    }


    public Comic getComicByComic_Id(Integer integer) {
        return comicRepository.getComicByComic_id(integer);
    }

}