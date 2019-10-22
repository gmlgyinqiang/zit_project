function app_compress(lenthKb,file, callback,$){
    var bili = 750/lenthKb;
    var reader = new FileReader();

    reader.onload = function (e) {

        var image = $('<img/>');
        image.on('load', function () {
            var imageWidth = Math.round(bili * this.width );
            var imageHeight = Math.round(bili * this.height );
            var offsetX = 0,offsetY = 0;
            var canvas = document.createElement('canvas');

            canvas.width = imageWidth;
            canvas.height = imageHeight;

            var context = canvas.getContext('2d');
            context.clearRect(0, 0, imageWidth, imageHeight);


            context.drawImage(this, offsetX, offsetY, imageWidth, imageHeight);
            var data = canvas.toDataURL('image/jpeg');
            callback(data);
        });

        image.attr('src', e.target.result);
    };

    reader.readAsDataURL(file);
}

/*************   图片文件压缩上传 end ****************/