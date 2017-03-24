package com.example.guowang.mto.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName:
 * @Description:(这里用一句话描述这个类的作用)
 * @author: 天源迪科
 * @date:
 * @Copyright: www.tydic.com Inc. All rights reserved.
 */
public class SongInfoBean implements Serializable {

    /**
     * songurl : {"url":[{"show_link":"http://zhangmenshiting.baidu.com/data2/music/8224132/8224132.mp3?xcode=e5f207480021998a6b73a0f684021956","down_type":1,"original":0,"free":1,"replay_gain":"0.000000","song_file_id":8224132,"file_size":3171976,"file_extension":"mp3","file_duration":198,"can_see":1,"can_load":true,"preload":80,"file_bitrate":128,"file_link":"http://yinyueshiting.baidu.com/data2/music/8224132/8224132.mp3?xcode=e5f207480021998a6b73a0f684021956","is_udition_url":0,"hash":""},{"show_link":"http://zhangmenshiting.baidu.com/data2/music/9568293/9568293.mp3?xcode=e5f207480021998a6b73a0f684021956","down_type":2,"original":0,"free":1,"replay_gain":"0.000000","song_file_id":9568293,"file_size":7951593,"file_extension":"mp3","file_duration":198,"can_see":1,"can_load":true,"preload":200,"file_bitrate":320,"file_link":"http://yinyueshiting.baidu.com/data2/music/9568293/9568293.mp3?xcode=e5f207480021998a6b73a0f684021956","is_udition_url":0,"hash":""}]}
     * error_code : 22000
     * songinfo : {"resource_type_ext":"0","comment_num":0,"pic_huge":"http://musicdata.baidu.com/data2/music/514A1D9129180CDC5BDF2F85D466AD24/253001644/253001644.jpg","resource_type":"0","original":0,"del_status":"0","korean_bb_song":"0","album_1000_1000":"http://musicdata.baidu.com/data2/music/514A1D9129180CDC5BDF2F85D466AD24/253001644/253001644.jpg","pic_singer":"","album_500_500":"http://musicdata.baidu.com/data2/music/514A1D9129180CDC5BDF2F85D466AD24/253001644/253001644.jpg@s_0,w_500","havehigh":2,"piao_id":"0","song_source":"web","collect_num":5,"compose":"Frederick Hibbert","toneid":"0","area":"2","original_rate":"","bitrate":"128,320","artist_500_500":"http://musicdata.baidu.com/data2/music/7408BF974EC5825573519068561A82E9/252303233/252303233.jpg@s_0,w_500","multiterminal_copytype":"","has_mv":0,"file_duration":"198","album_title":"The Harder They Come (Deluxe Edition)","sound_effect":"","title":"Do The Reggay","high_rate":"320","pic_radio":"http://musicdata.baidu.com/data2/music/514A1D9129180CDC5BDF2F85D466AD24/253001644/253001644.jpg@s_0,w_300","is_first_publish":0,"hot":"0","language":"","lrclink":"","distribution":"0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,1111110000,1111110000,0000000000","relate_status":"0","learn":0,"play_type":0,"pic_big":"http://musicdata.baidu.com/data2/music/514A1D9129180CDC5BDF2F85D466AD24/253001644/253001644.jpg@s_0,w_150","pic_premium":"http://musicdata.baidu.com/data2/music/514A1D9129180CDC5BDF2F85D466AD24/253001644/253001644.jpg@s_0,w_500","artist_480_800":"","aliasname":"","country":"欧美","artist_id":"7385097","album_id":"8223508","share_num":0,"compress_status":"0","versions":"","expire":36000,"ting_uid":"709797","artist_1000_1000":"http://musicdata.baidu.com/data2/music/7408BF974EC5825573519068561A82E9/252303233/252303233.jpg","all_artist_id":"7385097","artist_640_1136":"","publishtime":"2006-02-02","charge":0,"copy_type":"1","songwriting":"","share_url":"http://music.baidu.com/song/8223639","author":"Toots & The Maytals","has_mv_mobile":0,"all_rate":"128,320","pic_small":"http://musicdata.baidu.com/data2/music/514A1D9129180CDC5BDF2F85D466AD24/253001644/253001644.jpg@s_0,w_90","album_no":"15","song_id":"8223639","is_charge":"0"}
     */

    private SongurlBean songurl;
    private float error_code;
    private SonginfoDetailsBean songinfo;

    public SongurlBean getSongurl() {
        return songurl;
    }

    public void setSongurl(SongurlBean songurl) {
        this.songurl = songurl;
    }

    public float getError_code() {
        return error_code;
    }

    public void setError_code(float error_code) {
        this.error_code = error_code;
    }

    public SonginfoDetailsBean getSonginfo() {
        return songinfo;
    }

    public void setSonginfo(SonginfoDetailsBean songinfo) {
        this.songinfo = songinfo;
    }

    public static class SongurlBean {
        private List<UrlBean> url;

        public List<UrlBean> getUrl() {
            return url;
        }

        public void setUrl(List<UrlBean> url) {
            this.url = url;
        }

        public static class UrlBean {
            /**
             * show_link : http://zhangmenshiting.baidu.com/data2/music/8224132/8224132.mp3?xcode=e5f207480021998a6b73a0f684021956
             * down_type : 1
             * original : 0
             * free : 1
             * replay_gain : 0.000000
             * song_file_id : 8224132
             * file_size : 3171976
             * file_extension : mp3
             * file_duration : 198
             * can_see : 1
             * can_load : true
             * preload : 80
             * file_bitrate : 128
             * file_link : http://yinyueshiting.baidu.com/data2/music/8224132/8224132.mp3?xcode=e5f207480021998a6b73a0f684021956
             * is_udition_url : 0
             * hash :
             */

            private String show_link;
            private float down_type;
            private float original;
            private float free;
            private String replay_gain;
            private float song_file_id;
            private float file_size;
            private String file_extension;
            private float file_duration;
            private float can_see;
            private boolean can_load;
            private float preload;
            private float file_bitrate;
            private String file_link;
            private float is_udition_url;
            private String hash;

            public String getShow_link() {
                return show_link;
            }

            public void setShow_link(String show_link) {
                this.show_link = show_link;
            }

            public float getDown_type() {
                return down_type;
            }

            public void setDown_type(float down_type) {
                this.down_type = down_type;
            }

            public float getOriginal() {
                return original;
            }

            public void setOriginal(float original) {
                this.original = original;
            }

            public float getFree() {
                return free;
            }

            public void setFree(float free) {
                this.free = free;
            }

            public String getReplay_gain() {
                return replay_gain;
            }

            public void setReplay_gain(String replay_gain) {
                this.replay_gain = replay_gain;
            }

            public float getSong_file_id() {
                return song_file_id;
            }

            public void setSong_file_id(float song_file_id) {
                this.song_file_id = song_file_id;
            }

            public float getFile_size() {
                return file_size;
            }

            public void setFile_size(float file_size) {
                this.file_size = file_size;
            }

            public String getFile_extension() {
                return file_extension;
            }

            public void setFile_extension(String file_extension) {
                this.file_extension = file_extension;
            }

            public float getFile_duration() {
                return file_duration;
            }

            public void setFile_duration(float file_duration) {
                this.file_duration = file_duration;
            }

            public float getCan_see() {
                return can_see;
            }

            public void setCan_see(float can_see) {
                this.can_see = can_see;
            }

            public boolean isCan_load() {
                return can_load;
            }

            public void setCan_load(boolean can_load) {
                this.can_load = can_load;
            }

            public float getPreload() {
                return preload;
            }

            public void setPreload(float preload) {
                this.preload = preload;
            }

            public float getFile_bitrate() {
                return file_bitrate;
            }

            public void setFile_bitrate(float file_bitrate) {
                this.file_bitrate = file_bitrate;
            }

            public String getFile_link() {
                return file_link;
            }

            public void setFile_link(String file_link) {
                this.file_link = file_link;
            }

            public float getIs_udition_url() {
                return is_udition_url;
            }

            public void setIs_udition_url(float is_udition_url) {
                this.is_udition_url = is_udition_url;
            }

            public String getHash() {
                return hash;
            }

            public void setHash(String hash) {
                this.hash = hash;
            }
        }
    }

    public static class SonginfoDetailsBean {
        /**
         * resource_type_ext : 0
         * comment_num : 0
         * pic_huge : http://musicdata.baidu.com/data2/music/514A1D9129180CDC5BDF2F85D466AD24/253001644/253001644.jpg
         * resource_type : 0
         * original : 0
         * del_status : 0
         * korean_bb_song : 0
         * album_1000_1000 : http://musicdata.baidu.com/data2/music/514A1D9129180CDC5BDF2F85D466AD24/253001644/253001644.jpg
         * pic_singer :
         * album_500_500 : http://musicdata.baidu.com/data2/music/514A1D9129180CDC5BDF2F85D466AD24/253001644/253001644.jpg@s_0,w_500
         * havehigh : 2
         * piao_id : 0
         * song_source : web
         * collect_num : 5
         * compose : Frederick Hibbert
         * toneid : 0
         * area : 2
         * original_rate :
         * bitrate : 128,320
         * artist_500_500 : http://musicdata.baidu.com/data2/music/7408BF974EC5825573519068561A82E9/252303233/252303233.jpg@s_0,w_500
         * multiterminal_copytype :
         * has_mv : 0
         * file_duration : 198
         * album_title : The Harder They Come (Deluxe Edition)
         * sound_effect :
         * title : Do The Reggay
         * high_rate : 320
         * pic_radio : http://musicdata.baidu.com/data2/music/514A1D9129180CDC5BDF2F85D466AD24/253001644/253001644.jpg@s_0,w_300
         * is_first_publish : 0
         * hot : 0
         * language :
         * lrclink :
         * distribution : 0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,1111110000,1111110000,0000000000
         * relate_status : 0
         * learn : 0
         * play_type : 0
         * pic_big : http://musicdata.baidu.com/data2/music/514A1D9129180CDC5BDF2F85D466AD24/253001644/253001644.jpg@s_0,w_150
         * pic_premium : http://musicdata.baidu.com/data2/music/514A1D9129180CDC5BDF2F85D466AD24/253001644/253001644.jpg@s_0,w_500
         * artist_480_800 :
         * aliasname :
         * country : 欧美
         * artist_id : 7385097
         * album_id : 8223508
         * share_num : 0
         * compress_status : 0
         * versions :
         * expire : 36000
         * ting_uid : 709797
         * artist_1000_1000 : http://musicdata.baidu.com/data2/music/7408BF974EC5825573519068561A82E9/252303233/252303233.jpg
         * all_artist_id : 7385097
         * artist_640_1136 :
         * publishtime : 2006-02-02
         * charge : 0
         * copy_type : 1
         * songwriting :
         * share_url : http://music.baidu.com/song/8223639
         * author : Toots & The Maytals
         * has_mv_mobile : 0
         * all_rate : 128,320
         * pic_small : http://musicdata.baidu.com/data2/music/514A1D9129180CDC5BDF2F85D466AD24/253001644/253001644.jpg@s_0,w_90
         * album_no : 15
         * song_id : 8223639
         * is_charge : 0
         */

        private String resource_type_ext;
        private float comment_num;
        private String pic_huge;
        private String resource_type;
        private float original;
        private String del_status;
        private String korean_bb_song;
        private String album_1000_1000;
        private String pic_singer;
        private String album_500_500;
        private float havehigh;
        private String piao_id;
        private String song_source;
        private float collect_num;
        private String compose;
        private String toneid;
        private String area;
        private String original_rate;
        private String bitrate;
        private String artist_500_500;
        private String multiterminal_copytype;
        private float has_mv;
        private String file_duration;
        private String album_title;
        private String sound_effect;
        private String title;
        private String high_rate;
        private String pic_radio;
        private float is_first_publish;
        private String hot;
        private String language;
        private String lrclink;
        private String distribution;
        private String relate_status;
        private float learn;
        private float play_type;
        private String pic_big;
        private String pic_premium;
        private String artist_480_800;
        private String aliasname;
        private String country;
        private String artist_id;
        private String album_id;
        private float share_num;
        private String compress_status;
        private String versions;
        private float expire;
        private String ting_uid;
        private String artist_1000_1000;
        private String all_artist_id;
        private String artist_640_1136;
        private String publishtime;
        private float charge;
        private String copy_type;
        private String songwriting;
        private String share_url;
        private String author;
        private float has_mv_mobile;
        private String all_rate;
        private String pic_small;
        private String album_no;
        private String song_id;
        private String is_charge;

        public String getResource_type_ext() {
            return resource_type_ext;
        }

        public void setResource_type_ext(String resource_type_ext) {
            this.resource_type_ext = resource_type_ext;
        }

        public float getComment_num() {
            return comment_num;
        }

        public void setComment_num(float comment_num) {
            this.comment_num = comment_num;
        }

        public String getPic_huge() {
            return pic_huge;
        }

        public void setPic_huge(String pic_huge) {
            this.pic_huge = pic_huge;
        }

        public String getResource_type() {
            return resource_type;
        }

        public void setResource_type(String resource_type) {
            this.resource_type = resource_type;
        }

        public float getOriginal() {
            return original;
        }

        public void setOriginal(float original) {
            this.original = original;
        }

        public String getDel_status() {
            return del_status;
        }

        public void setDel_status(String del_status) {
            this.del_status = del_status;
        }

        public String getKorean_bb_song() {
            return korean_bb_song;
        }

        public void setKorean_bb_song(String korean_bb_song) {
            this.korean_bb_song = korean_bb_song;
        }

        public String getAlbum_1000_1000() {
            return album_1000_1000;
        }

        public void setAlbum_1000_1000(String album_1000_1000) {
            this.album_1000_1000 = album_1000_1000;
        }

        public String getPic_singer() {
            return pic_singer;
        }

        public void setPic_singer(String pic_singer) {
            this.pic_singer = pic_singer;
        }

        public String getAlbum_500_500() {
            return album_500_500;
        }

        public void setAlbum_500_500(String album_500_500) {
            this.album_500_500 = album_500_500;
        }

        public float getHavehigh() {
            return havehigh;
        }

        public void setHavehigh(float havehigh) {
            this.havehigh = havehigh;
        }

        public String getPiao_id() {
            return piao_id;
        }

        public void setPiao_id(String piao_id) {
            this.piao_id = piao_id;
        }

        public String getSong_source() {
            return song_source;
        }

        public void setSong_source(String song_source) {
            this.song_source = song_source;
        }

        public float getCollect_num() {
            return collect_num;
        }

        public void setCollect_num(float collect_num) {
            this.collect_num = collect_num;
        }

        public String getCompose() {
            return compose;
        }

        public void setCompose(String compose) {
            this.compose = compose;
        }

        public String getToneid() {
            return toneid;
        }

        public void setToneid(String toneid) {
            this.toneid = toneid;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getOriginal_rate() {
            return original_rate;
        }

        public void setOriginal_rate(String original_rate) {
            this.original_rate = original_rate;
        }

        public String getBitrate() {
            return bitrate;
        }

        public void setBitrate(String bitrate) {
            this.bitrate = bitrate;
        }

        public String getArtist_500_500() {
            return artist_500_500;
        }

        public void setArtist_500_500(String artist_500_500) {
            this.artist_500_500 = artist_500_500;
        }

        public String getMultiterminal_copytype() {
            return multiterminal_copytype;
        }

        public void setMultiterminal_copytype(String multiterminal_copytype) {
            this.multiterminal_copytype = multiterminal_copytype;
        }

        public float getHas_mv() {
            return has_mv;
        }

        public void setHas_mv(float has_mv) {
            this.has_mv = has_mv;
        }

        public String getFile_duration() {
            return file_duration;
        }

        public void setFile_duration(String file_duration) {
            this.file_duration = file_duration;
        }

        public String getAlbum_title() {
            return album_title;
        }

        public void setAlbum_title(String album_title) {
            this.album_title = album_title;
        }

        public String getSound_effect() {
            return sound_effect;
        }

        public void setSound_effect(String sound_effect) {
            this.sound_effect = sound_effect;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getHigh_rate() {
            return high_rate;
        }

        public void setHigh_rate(String high_rate) {
            this.high_rate = high_rate;
        }

        public String getPic_radio() {
            return pic_radio;
        }

        public void setPic_radio(String pic_radio) {
            this.pic_radio = pic_radio;
        }

        public float getIs_first_publish() {
            return is_first_publish;
        }

        public void setIs_first_publish(float is_first_publish) {
            this.is_first_publish = is_first_publish;
        }

        public String getHot() {
            return hot;
        }

        public void setHot(String hot) {
            this.hot = hot;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getLrclink() {
            return lrclink;
        }

        public void setLrclink(String lrclink) {
            this.lrclink = lrclink;
        }

        public String getDistribution() {
            return distribution;
        }

        public void setDistribution(String distribution) {
            this.distribution = distribution;
        }

        public String getRelate_status() {
            return relate_status;
        }

        public void setRelate_status(String relate_status) {
            this.relate_status = relate_status;
        }

        public float getLearn() {
            return learn;
        }

        public void setLearn(float learn) {
            this.learn = learn;
        }

        public float getPlay_type() {
            return play_type;
        }

        public void setPlay_type(float play_type) {
            this.play_type = play_type;
        }

        public String getPic_big() {
            return pic_big;
        }

        public void setPic_big(String pic_big) {
            this.pic_big = pic_big;
        }

        public String getPic_premium() {
            return pic_premium;
        }

        public void setPic_premium(String pic_premium) {
            this.pic_premium = pic_premium;
        }

        public String getArtist_480_800() {
            return artist_480_800;
        }

        public void setArtist_480_800(String artist_480_800) {
            this.artist_480_800 = artist_480_800;
        }

        public String getAliasname() {
            return aliasname;
        }

        public void setAliasname(String aliasname) {
            this.aliasname = aliasname;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getArtist_id() {
            return artist_id;
        }

        public void setArtist_id(String artist_id) {
            this.artist_id = artist_id;
        }

        public String getAlbum_id() {
            return album_id;
        }

        public void setAlbum_id(String album_id) {
            this.album_id = album_id;
        }

        public float getShare_num() {
            return share_num;
        }

        public void setShare_num(float share_num) {
            this.share_num = share_num;
        }

        public String getCompress_status() {
            return compress_status;
        }

        public void setCompress_status(String compress_status) {
            this.compress_status = compress_status;
        }

        public String getVersions() {
            return versions;
        }

        public void setVersions(String versions) {
            this.versions = versions;
        }

        public float getExpire() {
            return expire;
        }

        public void setExpire(float expire) {
            this.expire = expire;
        }

        public String getTing_uid() {
            return ting_uid;
        }

        public void setTing_uid(String ting_uid) {
            this.ting_uid = ting_uid;
        }

        public String getArtist_1000_1000() {
            return artist_1000_1000;
        }

        public void setArtist_1000_1000(String artist_1000_1000) {
            this.artist_1000_1000 = artist_1000_1000;
        }

        public String getAll_artist_id() {
            return all_artist_id;
        }

        public void setAll_artist_id(String all_artist_id) {
            this.all_artist_id = all_artist_id;
        }

        public String getArtist_640_1136() {
            return artist_640_1136;
        }

        public void setArtist_640_1136(String artist_640_1136) {
            this.artist_640_1136 = artist_640_1136;
        }

        public String getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(String publishtime) {
            this.publishtime = publishtime;
        }

        public float getCharge() {
            return charge;
        }

        public void setCharge(float charge) {
            this.charge = charge;
        }

        public String getCopy_type() {
            return copy_type;
        }

        public void setCopy_type(String copy_type) {
            this.copy_type = copy_type;
        }

        public String getSongwriting() {
            return songwriting;
        }

        public void setSongwriting(String songwriting) {
            this.songwriting = songwriting;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public float getHas_mv_mobile() {
            return has_mv_mobile;
        }

        public void setHas_mv_mobile(float                                                                                                                has_mv_mobile) {
            this.has_mv_mobile = has_mv_mobile;
        }

        public String getAll_rate() {
            return all_rate;
        }

        public void setAll_rate(String all_rate) {
            this.all_rate = all_rate;
        }

        public String getPic_small() {
            return pic_small;
        }

        public void setPic_small(String pic_small) {
            this.pic_small = pic_small;
        }

        public String getAlbum_no() {
            return album_no;
        }

        public void setAlbum_no(String album_no) {
            this.album_no = album_no;
        }

        public String getSong_id() {
            return song_id;
        }

        public void setSong_id(String song_id) {
            this.song_id = song_id;
        }

        public String getIs_charge() {
            return is_charge;
        }

        public void setIs_charge(String is_charge) {
            this.is_charge = is_charge;
        }
    }
}
