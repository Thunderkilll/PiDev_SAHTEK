<?php

namespace UserBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use UserBundle\Entity\Articles;
use UserBundle\Form\ArticlesType;

class articlesController extends Controller
{
    public function ajoutQuestionAction(Request $request){

        $article = new Articles();
              $Form =$this->createForm(ArticlesType::class,$article);
        if($Form->handleRequest($request)->isValid())
        {
            $m=$this->getDoctrine()->getManager();
            $m->persist($article);
            $m->flush();

            return $this->redirectToRoute('Page_questions');
        }
            return $this->render('UserBundle:menu_options:ajoutQuestion.html.twig',array('f'=>$Form->createView()));

    }

    public function listAction()
    {
        $m=$this->getDoctrine()->getManager();
        $articles=$m->getRepository('UserBundle:Articles')->findAll();
        return $this->render
        ('UserBundle:menu_options:QandA.html.twig',array('article'=>$articles));
    }


}
