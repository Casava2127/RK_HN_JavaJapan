import dlib  
from PIL import Image  
import numpy  
import argparse  

parser = argparse.ArgumentParser()  
parser.add_argument('image_path', type=str, help='path to image file')  
parser.add_argument('--use_cnn_detector', help='Force to use CNN detector, default detector is the classical one', action='store_true')  

if __name__ == '__main__':  
    # Get path to image from arguments  
    args = parser.parse_args()  
    image_path = args.image_path  

    # Decide which detector to use, default is to use classical detector  
    if args.use_cnn_detector:  
        detector_model_path = './model_data/mmod_human_face_detector.dat'  
        face_detector = dlib.cnn_face_detection_model_v1(detector_model_path)  
    else:  
        face_detector = dlib.get_frontal_face_detector()  

    # Read image from file  
    image = numpy.array(Image.open(image_path))  

    # Run face detector and output bounding boxes  
    dets = face_detector(image, 1)  

    # Display results  
    win = dlib.image_window()  

    print("Number of faces detected: {}".format(len(dets)))  
    if args.use_cnn_detector:  
        for i, d in enumerate(dets):  
            print("Detection {}: Left: {} Top: {} Right: {} Bottom: {} Confidence: {}".format(  
                i, d.rect.left(), d.rect.top(), d.rect.right(), d.rect.bottom(), d.confidence))  

        rects = dlib.rectangles()  
        rects.extend([d.rect for d in dets])  
    else:  
        for i, d in enumerate(dets):  
            print("Detection {}: Left: {} Top: {} Right: {} Bottom: {}".format(  
                i, d.left(), d.top(), d.right(), d.bottom()))  

        rects = dets  

    win.clear_overlay()  
    win.set_image(image)  
    win.add_overlay(rects)  
    dlib.hit_enter_to_continue()