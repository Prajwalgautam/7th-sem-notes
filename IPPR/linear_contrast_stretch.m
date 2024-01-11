function result = linear_contrast_stretch(img)
[width,height]= size(img);
result= zeros(width,height);

minPix = min(img(:));
maxPix = max(img(:));

for i= 1:width
    for j=1: height
        result(i,j)=uint8((255/(maxPix-minPix))*(img(i,j)-minPix));
    end
end

end