package com.alperen.service;

import com.alperen.config.ImgurConfig;
import com.alperen.dto.request.ImageCreateRequestDto;
import com.alperen.dto.response.CarResponseDto;
import com.alperen.entity.Image;
import com.alperen.entity.superclasses.Car;
import com.alperen.repository.ElectricCarRepository;
import com.alperen.repository.ImageRepository;
import com.alperen.utility.DataImpl;
import com.alperen.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageService extends ServiceManager<Image,Long> {
    private final ImageRepository imageRepository;
    private final ImgurConfig imgurConfig;
    private final ElectricCarRepository electricCarRepository;


    public ImageService(ImageRepository imageRepository, ImgurConfig imgurConfig, ElectricCarRepository electricCarRepository) {
        super(imageRepository);
        this.imageRepository = imageRepository;
        this.imgurConfig = imgurConfig;

        this.electricCarRepository = electricCarRepository;
    }


    public List<Image> createImage(ImageCreateRequestDto dto) {
        List<MultipartFile> multipartFileList = dto.getImages();
        List<Image> imageList = new ArrayList<>();
        for (MultipartFile image : multipartFileList) {
           String imageUrl = imgurConfig.upload(image);
           imageList.add(save(Image.builder().carCode(dto.getCarCode()).imageUrl(imageUrl).build()));
        }
        return imageList;
    }

//    public List<CarResponseDto> addDataImplImages(ImageCreateRequestDto dto){
//        List<CarResponseDto> carResponseDtoList = new ArrayList<>();
//        List<MultipartFile> multipartFileList = dto.getImages();
//        List<String> urlList  = new ArrayList<>();
//
//        List<Car> carList = electricCarRepository.findAll().stream().map(x-> (Car) x).collect(Collectors.toList());
//        for (MultipartFile image : multipartFileList) {
//            String imageUrl = imgurConfig.upload(image);
//            urlList.add(imageUrl);
//        }
//        for (Car car : carList){
//            for (int i = 0; i<4;i++){
//                save(Image.builder().carCode(car.getCarCode()).imageUrl(urlList.get(i)).build()).getImageUrl();
//            }
//            carResponseDtoList.add(CarResponseDto.builder().car(car).imageUrls(urlList.subList(0,4)).build());
//            urlList = urlList.subList(4,urlList.size());
//        }
//
//
//        return carResponseDtoList ;
//    }
}

