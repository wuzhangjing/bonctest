package com.wisely.springMvc.domain;

public class DemoObj {

    private Long id;
    private String name;

    //jackjson对对象和json做转换时一定需要次空构造
    public DemoObj(){
        super();
    }

    public DemoObj(Long id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
