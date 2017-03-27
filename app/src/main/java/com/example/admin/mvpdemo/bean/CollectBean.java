package com.example.admin.mvpdemo.bean;

import java.util.List;

/**
 * Created by admin on 2017/3/27.
 */

public class CollectBean {

        /**
         * id : 25
         * video_id : 1
         * create_time : 2017-02-25 10:59
         * uid : 36
         * video_name : 海贼王
         * video_img : /Uploads/Picture/2017-02-22/58ad3d4f4c901.jpg
         */

        private String id;
        private String video_id;
        private String create_time;
        private String uid;
        private String video_name;
        private String video_img;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getVideo_name() {
            return video_name;
        }

        public void setVideo_name(String video_name) {
            this.video_name = video_name;
        }

        public String getVideo_img() {
            return video_img;
        }

        public void setVideo_img(String video_img) {
            this.video_img = video_img;
        }

}
