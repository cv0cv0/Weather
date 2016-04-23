package com.gr.weather;

import java.util.List;

/**
 * Created by GR on 2016/4/20.
 */
public class Weather {

    /**
     * reason : successed!
     * result : {"data":{"realtime":{"wind":{"windspeed":"11.0","direct":"东北风","power":"1级","offset":null},"time":"13:00:00","weather":{"humidity":"97","img":"7","info":"小雨","temperature":"16"},"dataUptime":1461130084,"date":"2016-04-20","city_code":"101220101","city_name":"合肥","week":3,"moon":"三月十四"},"life":{"date":"2016-4-20","info":{"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"yundong":["较不宜","有较强降水，建议您选择在室内进行健身休闲运动。"],"ziwaixian":["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"],"ganmao":["极易发","将有一次强降温过程，天气寒冷，且空气湿度较大，极易发生感冒，请特别注意增加衣服保暖防寒。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":["优","气象条件非常有利于空气污染物稀释、扩散和清除，可在室外正常活动。"],"chuanyi":["较舒适","建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"]}},"weather":[{"date":"2016-04-20","info":{"night":["7","小雨","15","西风","3-4 级","18:43"],"day":["9","大雨","19","北风","微风","05:36"]},"week":"三","nongli":"三月十四"},{"date":"2016-04-21","info":{"dawn":["7","小雨","15","西风","3-4 级","18:43"],"night":["1","多云","17","南风","微风","18:44"],"day":["1","多云","25","南风","微风","05:34"]},"week":"四","nongli":"三月十五"},{"date":"2016-04-22","info":{"dawn":["1","多云","17","南风","微风","18:44"],"night":["7","小雨","16","东风","微风","18:44"],"day":["1","多云","27","东南风","微风","05:33"]},"week":"五","nongli":"三月十六"},{"date":"2016-04-23","info":{"dawn":["7","小雨","16","东风","微风","18:44"],"night":["1","多云","14","东风","4-5 级","18:45"],"day":["1","多云","22","东风","3-4 级","05:32"]},"week":"六","nongli":"三月十七"},{"date":"2016-04-24","info":{"dawn":["1","多云","14","东风","4-5 级","18:45"],"night":["2","阴","13","东风","3-4 级","18:46"],"day":["2","阴","21","东风","4-5 级","05:31"]},"week":"日","nongli":"三月十八"},{"date":"2016-04-25","info":{"night":["3","阵雨","14","东南风","微风","19:30"],"day":["1","多云","22","东南风","微风","07:30"]},"week":"一","nongli":"三月十九"},{"date":"2016-04-26","info":{"night":["3","阵雨","14","东北风","微风","19:30"],"day":["3","阵雨","20","东北风","微风","07:30"]},"week":"二","nongli":"三月二十"}],"pm25":{"key":"","show_desc":0,"pm25":{"curPm":"56","pm25":"59","pm10":"56","level":2,"quality":"良","des":"今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。"},"dateTime":"2016年04月20日13时","cityName":"合肥"},"date":null,"isForeign":0}}
     * error_code : 0
     */

    private String reason;
    /**
     * data : {"realtime":{"wind":{"windspeed":"11.0","direct":"东北风","power":"1级","offset":null},"time":"13:00:00","weather":{"humidity":"97","img":"7","info":"小雨","temperature":"16"},"dataUptime":1461130084,"date":"2016-04-20","city_code":"101220101","city_name":"合肥","week":3,"moon":"三月十四"},"life":{"date":"2016-4-20","info":{"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"yundong":["较不宜","有较强降水，建议您选择在室内进行健身休闲运动。"],"ziwaixian":["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"],"ganmao":["极易发","将有一次强降温过程，天气寒冷，且空气湿度较大，极易发生感冒，请特别注意增加衣服保暖防寒。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":["优","气象条件非常有利于空气污染物稀释、扩散和清除，可在室外正常活动。"],"chuanyi":["较舒适","建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"]}},"weather":[{"date":"2016-04-20","info":{"night":["7","小雨","15","西风","3-4 级","18:43"],"day":["9","大雨","19","北风","微风","05:36"]},"week":"三","nongli":"三月十四"},{"date":"2016-04-21","info":{"dawn":["7","小雨","15","西风","3-4 级","18:43"],"night":["1","多云","17","南风","微风","18:44"],"day":["1","多云","25","南风","微风","05:34"]},"week":"四","nongli":"三月十五"},{"date":"2016-04-22","info":{"dawn":["1","多云","17","南风","微风","18:44"],"night":["7","小雨","16","东风","微风","18:44"],"day":["1","多云","27","东南风","微风","05:33"]},"week":"五","nongli":"三月十六"},{"date":"2016-04-23","info":{"dawn":["7","小雨","16","东风","微风","18:44"],"night":["1","多云","14","东风","4-5 级","18:45"],"day":["1","多云","22","东风","3-4 级","05:32"]},"week":"六","nongli":"三月十七"},{"date":"2016-04-24","info":{"dawn":["1","多云","14","东风","4-5 级","18:45"],"night":["2","阴","13","东风","3-4 级","18:46"],"day":["2","阴","21","东风","4-5 级","05:31"]},"week":"日","nongli":"三月十八"},{"date":"2016-04-25","info":{"night":["3","阵雨","14","东南风","微风","19:30"],"day":["1","多云","22","东南风","微风","07:30"]},"week":"一","nongli":"三月十九"},{"date":"2016-04-26","info":{"night":["3","阵雨","14","东北风","微风","19:30"],"day":["3","阵雨","20","东北风","微风","07:30"]},"week":"二","nongli":"三月二十"}],"pm25":{"key":"","show_desc":0,"pm25":{"curPm":"56","pm25":"59","pm10":"56","level":2,"quality":"良","des":"今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。"},"dateTime":"2016年04月20日13时","cityName":"合肥"},"date":null,"isForeign":0}
     */

    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * realtime : {"wind":{"windspeed":"11.0","direct":"东北风","power":"1级","offset":null},"time":"13:00:00","weather":{"humidity":"97","img":"7","info":"小雨","temperature":"16"},"dataUptime":1461130084,"date":"2016-04-20","city_code":"101220101","city_name":"合肥","week":3,"moon":"三月十四"}
         * life : {"date":"2016-4-20","info":{"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"yundong":["较不宜","有较强降水，建议您选择在室内进行健身休闲运动。"],"ziwaixian":["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"],"ganmao":["极易发","将有一次强降温过程，天气寒冷，且空气湿度较大，极易发生感冒，请特别注意增加衣服保暖防寒。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":["优","气象条件非常有利于空气污染物稀释、扩散和清除，可在室外正常活动。"],"chuanyi":["较舒适","建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"]}}
         * weather : [{"date":"2016-04-20","info":{"night":["7","小雨","15","西风","3-4 级","18:43"],"day":["9","大雨","19","北风","微风","05:36"]},"week":"三","nongli":"三月十四"},{"date":"2016-04-21","info":{"dawn":["7","小雨","15","西风","3-4 级","18:43"],"night":["1","多云","17","南风","微风","18:44"],"day":["1","多云","25","南风","微风","05:34"]},"week":"四","nongli":"三月十五"},{"date":"2016-04-22","info":{"dawn":["1","多云","17","南风","微风","18:44"],"night":["7","小雨","16","东风","微风","18:44"],"day":["1","多云","27","东南风","微风","05:33"]},"week":"五","nongli":"三月十六"},{"date":"2016-04-23","info":{"dawn":["7","小雨","16","东风","微风","18:44"],"night":["1","多云","14","东风","4-5 级","18:45"],"day":["1","多云","22","东风","3-4 级","05:32"]},"week":"六","nongli":"三月十七"},{"date":"2016-04-24","info":{"dawn":["1","多云","14","东风","4-5 级","18:45"],"night":["2","阴","13","东风","3-4 级","18:46"],"day":["2","阴","21","东风","4-5 级","05:31"]},"week":"日","nongli":"三月十八"},{"date":"2016-04-25","info":{"night":["3","阵雨","14","东南风","微风","19:30"],"day":["1","多云","22","东南风","微风","07:30"]},"week":"一","nongli":"三月十九"},{"date":"2016-04-26","info":{"night":["3","阵雨","14","东北风","微风","19:30"],"day":["3","阵雨","20","东北风","微风","07:30"]},"week":"二","nongli":"三月二十"}]
         * pm25 : {"key":"","show_desc":0,"pm25":{"curPm":"56","pm25":"59","pm10":"56","level":2,"quality":"良","des":"今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。"},"dateTime":"2016年04月20日13时","cityName":"合肥"}
         * date : null
         * isForeign : 0
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * wind : {"windspeed":"11.0","direct":"东北风","power":"1级","offset":null}
             * time : 13:00:00
             * weather : {"humidity":"97","img":"7","info":"小雨","temperature":"16"}
             * dataUptime : 1461130084
             * date : 2016-04-20
             * city_code : 101220101
             * city_name : 合肥
             * week : 3
             * moon : 三月十四
             */

            private RealtimeBean realtime;
            /**
             * date : 2016-4-20
             * info : {"kongtiao":["较少开启","您将感到很舒适，一般不需要开启空调。"],"yundong":["较不宜","有较强降水，建议您选择在室内进行健身休闲运动。"],"ziwaixian":["最弱","属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"],"ganmao":["极易发","将有一次强降温过程，天气寒冷，且空气湿度较大，极易发生感冒，请特别注意增加衣服保暖防寒。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":["优","气象条件非常有利于空气污染物稀释、扩散和清除，可在室外正常活动。"],"chuanyi":["较舒适","建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"]}
             */

            private LifeBean life;
            /**
             * key :
             * show_desc : 0
             * pm25 : {"curPm":"56","pm25":"59","pm10":"56","level":2,"quality":"良","des":"今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。"}
             * dateTime : 2016年04月20日13时
             * cityName : 合肥
             */

            private Pm25Bean pm25;
            private Object date;
            private int isForeign;
            /**
             * date : 2016-04-20
             * info : {"night":["7","小雨","15","西风","3-4 级","18:43"],"day":["9","大雨","19","北风","微风","05:36"]}
             * week : 三
             * nongli : 三月十四
             */

            private List<WeatherBean> weather;

            public RealtimeBean getRealtime() {
                return realtime;
            }

            public void setRealtime(RealtimeBean realtime) {
                this.realtime = realtime;
            }

            public LifeBean getLife() {
                return life;
            }

            public void setLife(LifeBean life) {
                this.life = life;
            }

            public Pm25Bean getPm25() {
                return pm25;
            }

            public void setPm25(Pm25Bean pm25) {
                this.pm25 = pm25;
            }

            public Object getDate() {
                return date;
            }

            public void setDate(Object date) {
                this.date = date;
            }

            public int getIsForeign() {
                return isForeign;
            }

            public void setIsForeign(int isForeign) {
                this.isForeign = isForeign;
            }

            public List<WeatherBean> getWeather() {
                return weather;
            }

            public void setWeather(List<WeatherBean> weather) {
                this.weather = weather;
            }

            public static class RealtimeBean {
                /**
                 * windspeed : 11.0
                 * direct : 东北风
                 * power : 1级
                 * offset : null
                 */

                private WindBean wind;
                private String time;
                /**
                 * humidity : 97
                 * img : 7
                 * info : 小雨
                 * temperature : 16
                 */

                private WeatherBean weather;
                private int dataUptime;
                private String date;
                private String city_code;
                private String city_name;
                private int week;
                private String moon;

                public WindBean getWind() {
                    return wind;
                }

                public void setWind(WindBean wind) {
                    this.wind = wind;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public WeatherBean getWeather() {
                    return weather;
                }

                public void setWeather(WeatherBean weather) {
                    this.weather = weather;
                }

                public int getDataUptime() {
                    return dataUptime;
                }

                public void setDataUptime(int dataUptime) {
                    this.dataUptime = dataUptime;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getCity_code() {
                    return city_code;
                }

                public void setCity_code(String city_code) {
                    this.city_code = city_code;
                }

                public String getCity_name() {
                    return city_name;
                }

                public void setCity_name(String city_name) {
                    this.city_name = city_name;
                }

                public int getWeek() {
                    return week;
                }

                public void setWeek(int week) {
                    this.week = week;
                }

                public String getMoon() {
                    return moon;
                }

                public void setMoon(String moon) {
                    this.moon = moon;
                }

                public static class WindBean {
                    private String windspeed;
                    private String direct;
                    private String power;
                    private Object offset;

                    public String getWindspeed() {
                        return windspeed;
                    }

                    public void setWindspeed(String windspeed) {
                        this.windspeed = windspeed;
                    }

                    public String getDirect() {
                        return direct;
                    }

                    public void setDirect(String direct) {
                        this.direct = direct;
                    }

                    public String getPower() {
                        return power;
                    }

                    public void setPower(String power) {
                        this.power = power;
                    }

                    public Object getOffset() {
                        return offset;
                    }

                    public void setOffset(Object offset) {
                        this.offset = offset;
                    }
                }

                public static class WeatherBean {
                    private String humidity;
                    private String img;
                    private String info;
                    private String temperature;

                    public String getHumidity() {
                        return humidity;
                    }

                    public void setHumidity(String humidity) {
                        this.humidity = humidity;
                    }

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }

                    public String getInfo() {
                        return info;
                    }

                    public void setInfo(String info) {
                        this.info = info;
                    }

                    public String getTemperature() {
                        return temperature;
                    }

                    public void setTemperature(String temperature) {
                        this.temperature = temperature;
                    }
                }
            }

            public static class LifeBean {
                private String date;
                private InfoBean info;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public InfoBean getInfo() {
                    return info;
                }

                public void setInfo(InfoBean info) {
                    this.info = info;
                }

                public static class InfoBean {
                    private List<String> kongtiao;
                    private List<String> yundong;
                    private List<String> ziwaixian;
                    private List<String> ganmao;
                    private List<String> xiche;
                    private List<String> wuran;
                    private List<String> chuanyi;

                    public List<String> getKongtiao() {
                        return kongtiao;
                    }

                    public void setKongtiao(List<String> kongtiao) {
                        this.kongtiao = kongtiao;
                    }

                    public List<String> getYundong() {
                        return yundong;
                    }

                    public void setYundong(List<String> yundong) {
                        this.yundong = yundong;
                    }

                    public List<String> getZiwaixian() {
                        return ziwaixian;
                    }

                    public void setZiwaixian(List<String> ziwaixian) {
                        this.ziwaixian = ziwaixian;
                    }

                    public List<String> getGanmao() {
                        return ganmao;
                    }

                    public void setGanmao(List<String> ganmao) {
                        this.ganmao = ganmao;
                    }

                    public List<String> getXiche() {
                        return xiche;
                    }

                    public void setXiche(List<String> xiche) {
                        this.xiche = xiche;
                    }

                    public List<String> getWuran() {
                        return wuran;
                    }

                    public void setWuran(List<String> wuran) {
                        this.wuran = wuran;
                    }

                    public List<String> getChuanyi() {
                        return chuanyi;
                    }

                    public void setChuanyi(List<String> chuanyi) {
                        this.chuanyi = chuanyi;
                    }
                }
            }

            public static class Pm25Bean {
                private String key;
                private int show_desc;
                /**
                 * curPm : 56
                 * pm25 : 59
                 * pm10 : 56
                 * level : 2
                 * quality : 良
                 * des : 今天的空气质量是可以接受的，除少数异常敏感体质的人群外，大家可在户外正常活动。
                 */

                private Pm25 pm25;
                private String dateTime;
                private String cityName;

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public int getShow_desc() {
                    return show_desc;
                }

                public void setShow_desc(int show_desc) {
                    this.show_desc = show_desc;
                }

                public Pm25 getPm25() {
                    return pm25;
                }

                public void setPm25(Pm25 pm25) {
                    this.pm25 = pm25;
                }

                public String getDateTime() {
                    return dateTime;
                }

                public void setDateTime(String dateTime) {
                    this.dateTime = dateTime;
                }

                public String getCityName() {
                    return cityName;
                }

                public void setCityName(String cityName) {
                    this.cityName = cityName;
                }

                public static class Pm25 {
                    private String curPm;
                    private String pm25;
                    private String pm10;
                    private int level;
                    private String quality;
                    private String des;

                    public String getCurPm() {
                        return curPm;
                    }

                    public void setCurPm(String curPm) {
                        this.curPm = curPm;
                    }

                    public String getPm25() {
                        return pm25;
                    }

                    public void setPm25(String pm25) {
                        this.pm25 = pm25;
                    }

                    public String getPm10() {
                        return pm10;
                    }

                    public void setPm10(String pm10) {
                        this.pm10 = pm10;
                    }

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public String getQuality() {
                        return quality;
                    }

                    public void setQuality(String quality) {
                        this.quality = quality;
                    }

                    public String getDes() {
                        return des;
                    }

                    public void setDes(String des) {
                        this.des = des;
                    }
                }
            }

            public static class WeatherBean {
                private String date;
                private InfoBean info;
                private String week;
                private String nongli;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public InfoBean getInfo() {
                    return info;
                }

                public void setInfo(InfoBean info) {
                    this.info = info;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getNongli() {
                    return nongli;
                }

                public void setNongli(String nongli) {
                    this.nongli = nongli;
                }

                public static class InfoBean {
                    private List<String> night;
                    private List<String> day;

                    public List<String> getNight() {
                        return night;
                    }

                    public void setNight(List<String> night) {
                        this.night = night;
                    }

                    public List<String> getDay() {
                        return day;
                    }

                    public void setDay(List<String> day) {
                        this.day = day;
                    }
                }
            }
        }
    }
}
