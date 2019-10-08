package com.xz.demo.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import cn.hutool.core.util.ObjectUtil;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import com.lowagie.text.pdf.PdfReader;
public class PDF {




    public static void main(String[] args) {
        pdf2Image("D:/teams.pdf", "D:/png");
    }







    /***
     * PDF文件转PNG图片，全部页数
     *
     * @param PdfFilePath pdf完整路径
     * @param dstImgFolder 图片存放的文件夹
     * @return
     */

    private static void pdf2Image(String PdfFilePath, String dstImgFolder) {
        File file = new File(PdfFilePath);
        PDDocument pdDocument;
        try {
            String imgPDFPath = file.getParent();
            int dot = file.getName().lastIndexOf('.');
            String imagePDFName = file.getName().substring(0, dot); // 获取图片文件名
            String imgFolderPath = null;
            if (ObjectUtil.isNull(dstImgFolder)) {
                imgFolderPath = imgPDFPath + File.separator + imagePDFName;// 获取图片存放的文件夹路径
            } else {
                imgFolderPath = dstImgFolder + File.separator + imagePDFName;
            }
            if (createDirectory(imgFolderPath)) {
                pdDocument = PDDocument.load(file);
                PDFRenderer renderer = new PDFRenderer(pdDocument);
                /* dpi越大转换后越清晰，相对转换速度越慢 */
                PdfReader reader = new PdfReader(PdfFilePath);
                int pages = reader.getNumberOfPages();
                StringBuffer imgFilePath = null;
                for (int i = 0; i < pages; i++) {
                    String imgFilePathPrefix = imgFolderPath + File.separator + imagePDFName;
                    imgFilePath = new StringBuffer();
                    imgFilePath.append(imgFilePathPrefix);
                    imgFilePath.append("_");
                    imgFilePath.append((i + 1));
                    imgFilePath.append(".png");
                    File dstFile = new File(imgFilePath.toString());
                    BufferedImage image = renderer.renderImage(i, 0.75f);
                    ImageIO.write(image, "png", dstFile);
                }
                System.out.println("PDF文档转PNG图片成功！");
            } else {
                System.out.println("PDF文档转PNG图片失败：" + "创建" + imgFolderPath + "失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean createDirectory(String folder) {
        File dir = new File(folder);
        if (dir.exists()) {
            return true;
        } else {
            return dir.mkdirs();
        }
    }

}
