const base = {
    get() {
        return {
            url : "http://localhost:8080/zhongguogongchandangwangzhan/",
            name: "zhongguogongchandangwangzhan",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zhongguogongchandangwangzhan/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "中国共产党网站"
        } 
    }
}
export default base
