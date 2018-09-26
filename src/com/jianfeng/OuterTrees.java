package com.jianfeng;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者 E-mail: jianfeng.yang@tcl.com
 * @date 创建时间：九月 25, 2018 17:15
 */
public class OuterTrees {
    List<Point> ans = new ArrayList<>();
    public List<Point> outerTrees(Point[] points) {


        return ans;
    }

    public void divideUp(Point[] points, Point p1, Point p2){
        double maxDis = 0;
        for(Point point:points){
            int y = p1.y+(point.x-p1.x)*(p2.y-p1.y)/(p2.x-p1.x);
            if(point.y>y){

            }

        }
    }
}
