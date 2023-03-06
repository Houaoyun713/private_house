import request from '@/utils/request'

// 查询公告发布列表
export function listAnnrel(query) {
  return request({
    url: '/annrel/annrel/list',
    method: 'get',
    params: query
  })
}

// 查询公告发布详细
export function getAnnrel(id) {
  return request({
    url: '/annrel/annrel/' + id,
    method: 'get'
  })
}

// 新增公告发布
export function addAnnrel(data) {
  return request({
    url: '/annrel/annrel',
    method: 'post',
    data: data
  })
}

// 修改公告发布
export function updateAnnrel(data) {
  return request({
    url: '/annrel/annrel',
    method: 'put',
    data: data
  })
}

// 删除公告发布
export function delAnnrel(id) {
  return request({
    url: '/annrel/annrel/' + id,
    method: 'delete'
  })
}
