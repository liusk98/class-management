package com.myclass.tools;

import java.io.File;

/**
 * @author joe
 * @Date 2019/8/14
 */
public class HeadTools {

    /**
     * 功能描述:
     * 〈把审核通过的临时头像去掉temp后缀〉
     *
     * @param fileFullName
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/8/14 下午1:34
     */
    public static boolean renameHead(String fileFullName) {
        boolean result = false;
        fileFullName = fileFullName.replace("/", "\\");
        try {
            File oldFile = new File(fileFullName);
            String newFileName = fileFullName.replace("temp", "");
            File newFile = new File(newFileName);
            oldFile.renameTo(newFile);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 功能描述:
     * 〈删除单个文件〉
     *
     * @param fileName
     * @return boolean
     * @author 蜀山剑仙
     * @date 2019/8/14 下午3:56
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在,并且是一个文件,则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.printf("删除单个文件" + fileName + "成功!");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败!");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败: " + fileName + "不存在!");
            return false;
        }
    }
}
